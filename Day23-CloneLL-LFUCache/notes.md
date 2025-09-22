# Day 23 – Clone LL (Random Pointer, review) + LFU Cache

## ✅ What I Learned
### 1. Clone LL with Random Pointer (Review)
- **HashMap Approach** (easier to implement):
  - Traverse original list.
  - Create clone for each node, store mapping (old → new).
  - Second pass: assign next & random pointers using map.

- **Optimized O(1) Space Approach** (already learned earlier):
  - Insert clone nodes inside original list.
  - Fix random pointers.
  - Detach.

### 2. LFU Cache
- LFU = Least Frequently Used cache.
- Operations: `get(key)`, `put(key, value)` in **O(1)**.
- Uses:
  - **HashMap (key → node)**.
  - **HashMap (freq → doubly linked list)**.
  - Track min frequency.
- Steps:
  - On `get`: increase node frequency, move to new list.
  - On `put`: insert new node, evict LFU if capacity exceeded.

---

## 📖 Problems Practiced
1. Clone LL (review with HashMap approach)
2. LFU Cache (design problem)

---

## 🔑 Key Takeaways
- Random pointer copy: **HashMap = easy**, **O(1) space = optimal**.
- LFU Cache is harder than LRU → needs **two hash maps + linked lists**.
- Design problems test **data structure design + reasoning**.

