class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
}

public class EvenGroupOddEven {

    // ---------- Reverse Nodes in Even Length Groups ---------- //
    private Node reverseSegment(Node head, Node tail) {
        Node prev = tail.next;
        Node curr = head;
        while (prev != tail) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return tail; // new head after reverse
    }

    public Node reverseEvenLengthGroups(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node prevGroupEnd = dummy;
        int groupSize = 1;

        while (head != null) {
            Node tail = head;
            int cnt = 1;

            // move to end of this group
            while (cnt < groupSize && tail.next != null) {
                tail = tail.next;
                cnt++;
            }

            Node nextGroupHead = tail.next;

            // If even size → reverse this segment
            if (cnt % 2 == 0) {
                Node newHead = reverseSegment(head, tail);
                prevGroupEnd.next = newHead;
                prevGroupEnd = head;
            } else {
                prevGroupEnd = tail;
            }

            head = nextGroupHead;
            groupSize++;
        }

        return dummy.next;
    }

    // ---------- Odd-Even Linked List ---------- //
    public Node oddEvenList(Node head) {
        if (head == null) return null;

        Node odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
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
        EvenGroupOddEven solver = new EvenGroupOddEven();

        // Test Reverse Even Groups
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = new Node(5);
        h1.next.next.next.next.next = new Node(6);
        h1.next.next.next.next.next.next = new Node(7);
        h1.next.next.next.next.next.next.next = new Node(8);
        h1.next.next.next.next.next.next.next.next = new Node(9);

        System.out.println("Original List:");
        solver.printList(h1);
        Node evenReversed = solver.reverseEvenLengthGroups(h1);
        System.out.println("After Even Length Group Reversal:");
        solver.printList(evenReversed);

        // Test Odd-Even
        Node h2 = new Node(1);
        h2.next = new Node(2);
        h2.next.next = new Node(3);
        h2.next.next.next = new Node(4);
        h2.next.next.next.next = new Node(5);

        System.out.println("\nOriginal List:");
        solver.printList(h2);
        Node oddEven = solver.oddEvenList(h2);
        System.out.println("After Odd-Even Rearrangement:");
        solver.printList(oddEven);
    }
}
