class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleCycleLL {
    Node head;

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // Print list (safe print for non-cyclic lists)
    public void printList(int limit) {
        Node temp = head;
        int count = 0;
        while (temp != null && count < limit) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        }
        System.out.println("...");
    }

    // Find middle node
    public Node findMiddle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Detect cycle (Floyd's Algorithm)
    public boolean hasCycle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Find length of cycle
    public int cycleLength() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int length = 1;
                Node temp = slow.next;
                while (temp != slow) {
                    length++;
                    temp = temp.next;
                }
                return length;
            }
        }
        return 0;
    }

    // Find start of cycle
    public Node cycleStart() {
        Node slow = head, fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleCycleLL list = new MiddleCycleLL();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        System.out.print("List (safe print): ");
        list.printList(10);

        System.out.println("Middle Node: " + list.findMiddle().data);

        // Create a cycle for testing
        list.head.next.next.next.next.next = list.head.next.next; // 5 -> 3

        System.out.println("Has Cycle: " + list.hasCycle());
        System.out.println("Cycle Length: " + list.cycleLength());
        System.out.println("Cycle Starts At: " + list.cycleStart().data);
    }
}

