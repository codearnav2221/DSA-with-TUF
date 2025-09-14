# Day 17 – Detect & Remove Loop + Flatten Multilevel Linked List

## ✅ What I Learned
### 1. Detect & Remove Loop
- Use **Floyd’s Cycle Detection Algorithm** to detect loop.
- To remove loop:
  - Find loop start node.
  - Traverse till the last node of loop and make its `next = null`.

### 2. Flatten Multilevel Doubly Linked List
- Each node has `next`, `prev`, and `child` pointer.
- Flattening means: expand child lists in place so list becomes single-level doubly linked list.
- DFS or stack-based approach works.

---

## 📖 Problems Practiced
1. Detect if a Linked List has a Loop
2. Remove the Loop from Linked List
3. Flatten a Multilevel Doubly Linked List (LeetCode 430)

---

## 🔑 Key Takeaways
- Loop removal is an extension of cycle detection.
- Flattening requires careful handling of child lists.
- Both are **must-do interview questions**.

