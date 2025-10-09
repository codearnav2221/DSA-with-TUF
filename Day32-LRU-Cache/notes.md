# 🗓️ Day 32 — LRU Cache (Java)

## 📚 Topic:
**:contentReference[oaicite:0]{index=0} (LRU Cache)**

## 🧠 Key Concepts:
- **Goal:** Keep track of recently used elements. When cache is full, remove least recently used item.
- **Data Structure:** HashMap + Doubly Linked List
- **Time Complexity:** O(1) for `get()` and `put()`
- **Space Complexity:** O(capacity)

## 🛠️ Real-World Uses:
- Browser cache
- CPU cache
- OS page replacement

## 🧾 Algorithm:
1. Create a DLL with dummy head and tail.  
2. Use HashMap to store key → Node mapping.  
3. On `get(key)`:
   - If found, move node to head (MRU).
   - If not found, return `-1`.
4. On `put(key, value)`:
   - If key exists, remove old node.
   - If cache is full, remove node from tail (LRU).
   - Insert new node at head.

## 🧪 Example:
```java
LRUCache cache = new LRUCache(2);
cache.put(1, 1);
cache.put(2, 2);
System.out.println(cache.get(1)); // 1
cache.put(3, 3); // evicts 2
System.out.println(cache.get(2)); // -1

