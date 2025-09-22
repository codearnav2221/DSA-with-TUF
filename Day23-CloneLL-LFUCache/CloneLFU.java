import java.util.*;

// ------------------- Clone Linked List ------------------- //
class Node {
    int val;
    Node next;
    Node random;
    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class CloneLinkedList {
    // Clone using HashMap
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        // First pass: create clones
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: assign next & random
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    // Print with random pointers
    public void printList(Node node) {
        while (node != null) {
            String rand = (node.random != null) ? String.valueOf(node.random.val) : "null";
            System.out.print("(" + node.val + ", rand:" + rand + ") -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }
}

// ------------------- LFU Cache ------------------- //
class LFUCache {
    class LFUNode {
        int key, value, freq;
        LFUNode prev, next;
        LFUNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        LFUNode head, tail;
        int size;

        DoublyLinkedList() {
            head = new LFUNode(0, 0);
            tail = new LFUNode(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(LFUNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(LFUNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        LFUNode removeLast() {
            if (size > 0) {
                LFUNode node = tail.prev;
                removeNode(node);
                return node;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, LFUNode> nodeMap; // key → node
    private Map<Integer, DoublyLinkedList> freqMap; // freq → list

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        LFUNode node = nodeMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (nodeMap.containsKey(key)) {
            LFUNode node = nodeMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (nodeMap.size() >= capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                LFUNode toRemove = minList.removeLast();
                nodeMap.remove(toRemove.key);
            }
            LFUNode newNode = new LFUNode(key, value);
            nodeMap.put(key, newNode);
            minFreq = 1;
            freqMap.putIfAbsent(1, new DoublyLinkedList());
            freqMap.get(1).addNode(newNode);
        }
    }

    private void updateFreq(LFUNode node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).addNode(node);
    }
}

// ------------------- Main ------------------- //
public class CloneLFU {
    public static void main(String[] args) {
        // Test Clone LL
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

        CloneLinkedList cloner = new CloneLinkedList();
        Node cloned = cloner.copyRandomList(n1);

        System.out.println("Cloned Random List:");
        cloner.printList(cloned);

        // Test LFU Cache
        System.out.println("\nLFU Cache Test:");
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Get 1: " + cache.get(1)); // 1
        cache.put(3, 3); // evicts key 2
        System.out.println("Get 2: " + cache.get(2)); // -1
        System.out.println("Get 3: " + cache.get(3)); // 3
        cache.put(4, 4); // evicts key 1
        System.out.println("Get 1: " + cache.get(1)); // -1
        System.out.println("Get 3: " + cache.get(3)); // 3
        System.out.println("Get 4: " + cache.get(4)); // 4
    }
}

