class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortReorder {
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

    // Find middle (helper)
    private Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // Sort Linked List (Merge Sort)
    public Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = sortList(head);
        Node right = sortList(nextOfMiddle);

        return merge(left, right);
    }

    // Reverse a list
    private Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Reorder List
    public void reorderList(Node head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node second = reverse(slow.next);
        slow.next = null;

        // Step 3: Merge two halves
        Node first = head;
        while (second != null) {
            Node temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public static void main(String[] args) {
        SortReorder list = new SortReorder();

        // Test Sort
        list.insertAtTail(4);
        list.insertAtTail(2);
        list.insertAtTail(1);
        list.insertAtTail(3);

        System.out.print("Original List: ");
        list.printList(list.head);

        Node sorted = list.sortList(list.head);
        System.out.print("Sorted List: ");
        list.printList(sorted);

        // Test Reorder
        SortReorder list2 = new SortReorder();
        list2.insertAtTail(1);
        list2.insertAtTail(2);
        list2.insertAtTail(3);
        list2.insertAtTail(4);
        list2.insertAtTail(5);

        System.out.print("Before Reorder: ");
        list2.printList(list2.head);

        list2.reorderList(list2.head);
        System.out.print("After Reorder: ");
        list2.printList(list2.head);
    }
}

