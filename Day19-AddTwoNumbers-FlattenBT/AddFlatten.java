class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class AddFlatten {
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

    // Print linked list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    // Add Two Numbers (Linked List)
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    // Flatten Binary Tree to Linked List
    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // Find rightmost of left subtree
                TreeNode rightMost = curr.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                // Connect right subtree
                rightMost.right = curr.right;

                // Move left to right
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // Print Flattened Tree
    public static void printFlattened(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Add Two Numbers Test
        AddFlatten list1 = new AddFlatten();
        list1.insertAtTail(2);
        list1.insertAtTail(4);
        list1.insertAtTail(3);

        AddFlatten list2 = new AddFlatten();
        list2.insertAtTail(5);
        list2.insertAtTail(6);
        list2.insertAtTail(4);

        System.out.print("List1: ");
        list1.printList(list1.head);
        System.out.print("List2: ");
        list2.printList(list2.head);

        Node sum = addTwoNumbers(list1.head, list2.head);
        System.out.print("Sum: ");
        list1.printList(sum);

        // Flatten Binary Tree Test
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.print("Flattened Tree: ");
        flatten(root);
        printFlattened(root);
    }
}

