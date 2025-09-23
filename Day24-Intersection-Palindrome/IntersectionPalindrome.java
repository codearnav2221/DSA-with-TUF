class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionPalindrome {

    // ---------------- Intersection ---------------- //
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA, b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // either intersection node or null
    }

    // ---------------- Palindrome ---------------- //
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

    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find middle
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);

        // Compare halves
        Node p1 = head, p2 = secondHalf;
        boolean isPal = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPal = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore list (optional)
        slow.next = reverse(secondHalf);

        return isPal;
    }

    // ---------------- Test ---------------- //
    public static void main(String[] args) {
        IntersectionPalindrome sol = new IntersectionPalindrome();

        // Test Intersection
        Node common = new Node(8);
        common.next = new Node(10);

        Node headA = new Node(3);
        headA.next = new Node(7);
        headA.next.next = common;

        Node headB = new Node(99);
        headB.next = new Node(1);
        headB.next.next = common;

        Node intersect = sol.getIntersectionNode(headA, headB);
        System.out.println("Intersection Node: " + (intersect != null ? intersect.val : "null"));

        // Test Palindrome
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        System.out.println("Is Palindrome: " + sol.isPalindrome(head));
    }
}

