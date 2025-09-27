class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
}

public class SwapKGroup {

    // ---------- Swap Nodes in Pairs ---------- //
    public Node swapPairs(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = prev.next.next;

            // Swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev forward
            prev = first;
        }

        return dummy.next;
    }

    // ---------- Reverse Nodes in k-Group (Iterative) ---------- //
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy, curr = dummy, nex = dummy;

        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        while (count >= k) {
            curr = pre.next;
            nex = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count -= k;
        }

        return dummy.next;
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
        SwapKGroup solver = new SwapKGroup();

        // Test Swap Pairs
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        System.out.println("Original List:");
        solver.printList(head1);
        Node swapped = solver.swapPairs(head1);
        System.out.println("After Swap Pairs:");
        solver.printList(swapped);

        // Test k-Group Reversal
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        System.out.println("\nOriginal List:");
        solver.printList(head2);
        Node reversed = solver.reverseKGroup(head2, 3);
        System.out.println("After k=3 Reversal:");
        solver.printList(reversed);
    }
}

