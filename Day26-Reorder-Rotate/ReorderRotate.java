class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
}

public class ReorderRotate {

    // ---------- Reorder List ---------- //
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

    public void reorderList(Node head) {
        if (head == null || head.next == null) return;

        // Find middle
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node second = reverse(slow.next);
        slow.next = null;

        // Merge two halves
        Node first = head;
        while (second != null) {
            Node tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    // ---------- Rotate List ---------- //
    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Compute length
        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Make circular
        tail.next = head;
        k = k % len;
        int stepsToNewHead = len - k;

        Node newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    // ---------- Utility ---------- //
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    // ---------- Main ---------- //
    public static void main(String[] args) {
        ReorderRotate rr = new ReorderRotate();

        // Test Reorder
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        rr.printList(head1);
        rr.reorderList(head1);
        System.out.println("Reordered List:");
        rr.printList(head1);

        // Test Rotate
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        System.out.println("\nOriginal List:");
        rr.printList(head2);
        Node rotated = rr.rotateRight(head2, 2);
        System.out.println("Rotated by 2:");
        rr.printList(rotated);
    }
}

