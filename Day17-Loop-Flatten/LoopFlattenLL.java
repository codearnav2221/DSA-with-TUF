class Node {
    int data;
    Node next;

    // For doubly & multilevel list
    Node prev;
    Node child;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
        this.child = null;
    }
}

public class LoopFlattenLL {
    Node head;

    // Insert at tail (singly)
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

    // Print list (safe with limit)
    public void printList(Node node, int limit) {
        int count = 0;
        while (node != null && count < limit) {
            System.out.print(node.data + " -> ");
            node = node.next;
            count++;
        }
        System.out.println("...");
    }

    // Detect loop
    public boolean hasLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Remove loop
    public void removeLoop() {
        Node slow = head, fast = head;
        boolean loopExists = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists) return;

        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Break loop
        prev.next = null;
    }

    // Flatten multilevel doubly linked list
    public Node flatten(Node head) {
        if (head == null) return head;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node child = curr.child;
                Node next = curr.next;

                // Flatten child recursively
                Node childTail = flatten(child);

                // Connect curr and child
                curr.next = child;
                child.prev = curr;
                curr.child = null;

                // Connect childTail with next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                curr = childTail;
            }
            curr = curr.next;
        }
        return head;
    }

    // Utility to get tail of doubly list
    private Node flatten(Node childHead) {
        Node curr = childHead;
        Node tail = childHead;
        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null) {
                Node childTail = flatten(curr.child);

                // Connect child
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                tail = childTail;
                curr = childTail;
            } else {
                tail = curr;
            }
            curr = curr.next;
        }
        return tail;
    }

    public static void main(String[] args) {
        // Test Loop Removal
        LoopFlattenLL list = new LoopFlattenLL();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        // Create loop: 5 -> 3
        list.head.next.next.next.next.next = list.head.next.next;

        System.out.println("Has Loop: " + list.hasLoop());
        list.removeLoop();
        System.out.println("Has Loop After Removal: " + list.hasLoop());
        System.out.print("List After Loop Removal: ");
        list.printList(list.head, 10);

        // Test Flatten Multilevel Doubly LL
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;

        Node child1 = new Node(7);
        Node child2 = new Node(8);
        child1.next = child2; child2.prev = child1;
        n2.child = child1;

        LoopFlattenLL lf = new LoopFlattenLL();
        Node flatHead = lf.flatten(head);

        System.out.print("Flattened List: ");
        Node temp = flatHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

