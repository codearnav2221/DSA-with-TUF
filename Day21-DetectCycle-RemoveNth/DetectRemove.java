class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectRemove {
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

    // Print list (for testing - limit length to avoid infinite loop)
    public void printList(Node node) {
        int count = 0;
        while (node != null && count < 20) {
            System.out.print(node.data + " -> ");
            node = node.next;
            count++;
        }
        System.out.println((node != null) ? "..." : "NULL");
    }

    // Detect cycle (return true/false)
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    // Find cycle start node
    public Node detectCycle(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // Remove N-th node from end
    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy, slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast hits end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        DetectRemove list = new DetectRemove();

        // Test Remove N-th Node
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        System.out.print("Original List: ");
        list.printList(list.head);

        Node modified = list.removeNthFromEnd(list.head, 2);
        System.out.print("After Removing 2nd from End: ");
        list.printList(modified);

        // Test Detect Cycle
        DetectRemove cycleList = new DetectRemove();
        cycleList.insertAtTail(3);
        cycleList.insertAtTail(2);
        cycleList.insertAtTail(0);
        cycleList.insertAtTail(-4);

        // Create cycle (last node pointing to 2nd node)
        cycleList.head.next.next.next.next = cycleList.head.next;

        System.out.println("Has Cycle? " + cycleList.hasCycle(cycleList.head));
        Node cycleStart = cycleList.detectCycle(cycleList.head);
        System.out.println("Cycle starts at node with value: " + (cycleStart != null ? cycleStart.data : "None"));
    }
}
