# Day 25 – Flatten a Multilevel LL & Sort a Linked List

## ✅ What I Learned
### 1. Flatten a Multilevel Linked List
- Each node has:
  - `next` pointer (like usual).
  - `bottom` pointer (like sub-linked lists).
- Goal: Flatten to a **single sorted list**.
- Idea:
  1. Recursively flatten `next`.
  2. Merge current list (via bottom) with flattened `next`.
- Essentially → series of sorted merges.

### 2. Sort a Linked List (Merge Sort)
- LL sorting → merge sort is ideal.
- Steps:
  1. Find middle with slow/fast.
  2. Split into two halves.
  3. Recursively sort both halves.
  4. Merge sorted halves.

---

## 📖 Problems Practiced
1. Flatten a multilevel linked list.
2. Sort a linked list using merge sort.

---

## 🔑 Key Takeaways
- Flatten LL is a **variation of merge k sorted lists**.
- Merge Sort is the **go-to sorting algo for LL** since random access is not possible.
- Both problems improve **recursion + merge skills**.

