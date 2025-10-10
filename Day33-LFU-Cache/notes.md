# 🗓️ Day 33 — LFU Cache (Java)

## 📚 Topic:
**Least Frequently Used Cache (LFU Cache)**

## 🧠 Key Concepts:
- Removes the **least frequently used** item when capacity is full.
- Combines **frequency count** with **recency**.
- Used where data access patterns depend on usage frequency.

## 🧩 Data Structures Used:
1. **HashMap** → key → node (stores value + frequency)
2. **HashMap** → freq → DoublyLinkedList of nodes
3. Keep track of `minFreq` to know which list to evict from.

## ⏱️ Time & Space Complexity:
- `get()` → O(1)  
- `put()` → O(1)  
- Space → O(capacity)

## 🧾 Algorithm:
1. When a key is accessed, increase its frequency and move it to the next freq list.
2. When inserting:
   - If full, remove the least recently used node from the least frequency list.
3. Update `minFreq` accordingly.

## 🧪 Example:
```java
LFUCache cache = new LFUCache(2);
cache.put(1, 1);
cache.put(2, 2);
System.out.println(cache.get(1)); // 1
cache.put(3, 3); // evicts key 2
System.out.println(cache.get(2)); // -1
System.out.println(cache.get(3)); // 3

