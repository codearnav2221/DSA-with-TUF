import java.util.*;

class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class RotateCopyRandomLL {
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

    // Print list with optional random pointers
    public void printList(Node node) {
        while (node != null) {
            String rand = (node.random != null) ? String.valueOf(node.random.data) : "null";
            System.out.print("(" + node.data + ", rand:" + rand + ") -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    // Rotate linked list by k
    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Find length and tail
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        Node tail = temp;

        // Make it circular
        tail.next = head;

        // Find new head
        k = k % length;
        int stepsToNewHead = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }

    // Copy list with random pointers (O(1) space)
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // Step 1: Insert cloned nodes in between
        while (curr != null) {
            Node next = curr.next;
            Node copy = new Node(curr.data);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        // Step 2: Fix random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate cloned list
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test Rotate
        RotateCopyRandomLL list = new RotateCopyRandomLL();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        System.out.print("Original List: ");
        list.printList(list.head);

        Node rotated = list.rotateRight(list.head, 2);
        System.out.print("After Rotating by 2: ");
        list.printList(rotated);

        // Test Copy Random Pointer
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        RotateCopyRandomLL obj = new RotateCopyRandomLL();
        System.out.print("Original Random List: ");
        obj.printList(n1);

        Node copied = obj.copyRandomList(n1);
        System.out.print("Copied Random List: ");
        obj.printList(copied);
    }
}

