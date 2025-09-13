class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteMiddleIntersectionLL {
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

    // Print list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    // Delete middle node
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Remove slow (middle)
        prev.next = slow.next;
        return head;
    }

    // Find intersection node
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA, b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        // Delete Middle Test
        DeleteMiddleIntersectionLL list1 = new DeleteMiddleIntersectionLL();
        list1.insertAtTail(1);
        list1.insertAtTail(2);
        list1.insertAtTail(3);
        list1.insertAtTail(4);
        list1.insertAtTail(5);

        System.out.print("Original List: ");
        list1.printList(list1.head);

        list1.head = deleteMiddle(list1.head);
        System.out.print("After Deleting Middle: ");
        list1.printList(list1.head);

        // Intersection Test
        DeleteMiddleIntersectionLL listA = new DeleteMiddleIntersectionLL();
        DeleteMiddleIntersectionLL listB = new DeleteMiddleIntersectionLL();

        listA.insertAtTail(1);
        listA.insertAtTail(9);
        listA.insertAtTail(1);

        listB.insertAtTail(3);

        Node common = new Node(2);
        common.next = new Node(4);

        // Attach common part
        listA.head.next.next.next = common;
        listB.head.next = common;

        System.out.print("List A: ");
        listA.printList(listA.head);
        System.out.print("List B: ");
        listB.printList(listB.head);

        Node intersection = getIntersectionNode(listA.head, listB.head);
        System.out.println("Intersection Node: " + (intersection != null ? intersection.data : "None"));
    }
}

