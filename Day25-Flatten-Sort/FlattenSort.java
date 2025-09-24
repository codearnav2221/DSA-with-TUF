class BottomNode {
    int val;
    BottomNode next;
    BottomNode bottom;
    BottomNode(int val) {
        this.val = val;
        this.next = null;
        this.bottom = null;
    }
}

class FlattenSort {

    // ---------------- Flatten a Linked List ---------------- //
    private BottomNode merge(BottomNode a, BottomNode b) {
        if (a == null) return b;
        if (b == null) return a;

        BottomNode result;
        if (a.val < b.val) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        return result;
    }

    public BottomNode flatten(BottomNode root) {
        if (root == null || root.next == null) return root;
        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }

    public void printBottomList(BottomNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.bottom;
        }
        System.out.println("NULL");
    }

    // ---------------- Sort a Linked List ---------------- //
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        // find middle
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // split list

        Node left = mergeSort(head);
        Node right = mergeSort(slow);

        return mergeTwoLists(left, right);
    }

    private Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
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

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    // ---------------- Test ---------------- //
    public static void main(String[] args) {
        FlattenSort fs = new FlattenSort();

        // Flatten test
        BottomNode root = new BottomNode(5);
        root.bottom = new BottomNode(7);
        root.bottom.bottom = new BottomNode(8);
        root.bottom.bottom.bottom = new BottomNode(30);

        root.next = new BottomNode(10);
        root.next.bottom = new BottomNode(20);

        root.next.next = new BottomNode(19);
        root.next.next.bottom = new BottomNode(22);
        root.next.next.bottom.bottom = new BottomNode(50);

        root.next.next.next = new BottomNode(28);
        root.next.next.next.bottom = new BottomNode(35);
        root.next.next.next.bottom.bottom = new BottomNode(40);
        root.next.next.next.bottom.bottom.bottom = new BottomNode(45);

        System.out.println("Flattened List:");
        BottomNode flat = fs.flatten(root);
        fs.printBottomList(flat);

        // Sort test
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("\nOriginal List:");
        fs.printList(head);

        Node sorted = fs.mergeSort(head);
        System.out.println("Sorted List:");
        fs.printList(sorted);
    }
}

