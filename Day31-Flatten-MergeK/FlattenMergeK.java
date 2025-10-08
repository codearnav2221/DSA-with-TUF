import java.util.PriorityQueue;

class Node {
    int val;
    Node next;
    Node bottom;
    Node(int val) { this.val = val; }
}

public class FlattenMergeK {

    // ---------- Flatten a Linked List (GFG Style) ---------- //
    private Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node temp = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
        }
        if (a != null) temp.bottom = a;
        else temp.bottom = b;

        return dummy.bottom;
    }

    public Node flatten(Node root) {
        if (root == null || root.next == null) return root;
        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }

    // ---------- Merge K Sorted Linked Lists (Min-Heap) ---------- //
    public Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (Node list : lists) {
            if (list != null) minHeap.offer(list);
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!minHeap.isEmpty()) {
            Node min = minHeap.poll();
            tail.next = min;
            tail = tail.next;
            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }

        return dummy.next;
    }

    // ---------- Utility ---------- //
    public void printBottomList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.bottom;
        }
        System.out.println("NULL");
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    // ---------- Main ---------- //
    public static void main(String[] args) {
        FlattenMergeK solver = new FlattenMergeK();

        // Test Flatten
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        System.out.println("Flattening multilevel LL...");
        Node flat = solver.flatten(head);
        solver.printBottomList(flat);

        // Test Merge K Lists
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node l3 = new Node(2);
        l3.next = new Node(6);

        Node[] lists = {l1, l2, l3};
        Node merged = solver.mergeKLists(lists);

        System.out.println("\nMerging K Sorted Lists...");
        solver.printList(merged);
    }
}
