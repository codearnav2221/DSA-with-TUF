import java.util.*;

// Node for Linked List
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Doubly linked list node for LRU
class DNode {
    int key, value;
    DNode prev, next;
    DNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class KGroupLRU {
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
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    // Reverse k nodes
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = dummy, nex = dummy, pre = dummy;

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

    // ---------------- LRU Cache ---------------- //
    static class LRUCache {
        private int capacity;
        private Map<Integer, DNode> map;
        private DNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new DNode(0, 0);
            tail = new DNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        // Remove node from DLL
        private void remove(DNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Insert node after head
        private void insert(DNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DNode node = map.get(key);
                remove(node);
                insert(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            DNode node = new DNode(key, value);
            map.put(key, node);
            insert(node);

            if (map.size() > capacity) {
                DNode lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    public static void main(String[] args) {
        // Test Reverse k-group
        KGroupLRU list = new KGroupLRU();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        System.out.print("Original List: ");
        list.printList(list.head);

        Node reversed = list.reverseKGroup(list.head, 2);
        System.out.print("After k=2 Reversal: ");
        list.printList(reversed);

        // Test LRU Cache
        System.out.println("\nLRU Cache Test:");
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Get 1: " + cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println("Get 2: " + cache.get(2)); // returns -1
        cache.put(4, 4); // evicts key 1
        System.out.println("Get 1: " + cache.get(1)); // returns -1
        System.out.println("Get 3: " + cache.get(3)); // returns 3
        System.out.println("Get 4: " + cache.get(4)); // returns 4
    }
}

