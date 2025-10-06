class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
}

public class CycleDetectionIntersection {

    // ---------- Detect Cycle ---------- //
    public boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // ---------- Find Start of Cycle ---------- //
    public Node detectCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // cycle start
            }
        }
        return null;
    }

    // ---------- Remove Cycle ---------- //
    public void removeCycle(Node head) {
        Node start = detectCycle(head);
        if (start == null) return;

        Node temp = start;
        while (temp.next != start) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // ---------- Intersection of Two LLs ---------- //
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA, b = headB;
        // Switch heads when reaching end
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
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
        CycleDetectionIntersection solver = new CycleDetectionIntersection();

        // Detect Cycle
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = h1.next; // create cycle

        System.out.println("Has Cycle? " + solver.hasCycle(h1));
        System.out.println("Cycle Starts at Node: " + solver.detectCycle(h1).val);

        solver.removeCycle(h1);
        System.out.println("Has Cycle After Removal? " + solver.hasCycle(h1));

        // Intersection
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node c1 = new Node(8);
        Node c2 = new Node(9);
        a1.next = a2; a2.next = c1; c1.next = c2;

        Node b1 = new Node(3);
        Node b2 = new Node(4);
        b1.next = b2; b2.next = c1;

        Node intersection = solver.getIntersectionNode(a1, b1);
        System.out.println("Intersection Node Value: " + (intersection != null ? intersection.val : "None"));
    }
}
