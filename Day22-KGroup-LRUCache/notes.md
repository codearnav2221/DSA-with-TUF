# Day 22 – Reverse Nodes in k-Group & LRU Cache

## ✅ What I Learned
### 1. Reverse Nodes in k-Group
- Given a linked list, reverse nodes in groups of k.
- If remaining nodes < k → leave as is.
- Steps:
  1. Count nodes.
  2. Reverse k nodes at a time.
  3. Recursively/iteratively process rest.

### 2. LRU Cache
- LRU = Least Recently Used cache.
- Operations:
  - `get(key)` → return value if exists, else -1.
  - `put(key, value)` → insert/update; evict least recently used if capacity exceeded.
- Efficient solution = **Doubly Linked List + HashMap**.
  - DLL stores (key, value).
  - HashMap stores references for O(1) lookup.
  - Recently used → move node to head.
  - Least used → remove from tail.

---

## 📖 Problems Practiced
1. Reverse nodes in k-group
2. LRU Cache implementation

---

## 🔑 Key Takeaways
- k-Group reversal is **extension of reverse list**, but chunked.
- LRU Cache tests **DS + design skills**.
- Both are **very common interview favorites (Amazon, Google, Microsoft)**.

