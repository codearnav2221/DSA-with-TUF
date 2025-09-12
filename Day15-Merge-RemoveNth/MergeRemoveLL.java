class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeRemoveLL {
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
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Merge two sorted linked lists (Iterative)
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(-1);
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
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    // Remove N-th node from end
    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy, fast = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove node
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // List1: 1 -> 3 -> 5
        MergeRemoveLL list1 = new MergeRemoveLL();
        list1.insertAtTail(1);
        list1.insertAtTail(3);
        list1.insertAtTail(5);

        // List2: 2 -> 4 -> 6
        MergeRemoveLL list2 = new MergeRemoveLL();
        list2.insertAtTail(2);
        list2.insertAtTail(4);
        list2.insertAtTail(6);

        System.out.print("List1: ");
        list1.printList();
        System.out.print("List2: ");
        list2.printList();

        Node mergedHead = mergeTwoLists(list1.head, list2.head);
        System.out.print("Merged List: ");
        Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");

        // Remove 2nd node from end of merged list
        mergedHead = removeNthFromEnd(mergedHead, 2);
        System.out.print("After removing 2nd node from end: ");
        temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

