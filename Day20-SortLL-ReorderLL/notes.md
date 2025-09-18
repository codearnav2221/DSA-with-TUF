# Day 20 – Sort a Linked List + Reorder List

## ✅ What I Learned
### 1. Sort a Linked List
- Sorting a linked list efficiently = **Merge Sort**.
- Reason: QuickSort/HeapSort not efficient due to random access issues.
- Steps:
  1. Find middle using slow/fast pointer.
  2. Recursively sort both halves.
  3. Merge two sorted halves.

### 2. Reorder List
- Rearrange list as: L0 → Ln → L1 → Ln-1 → ...
- Steps:
  1. Find middle.
  2. Reverse second half.
  3. Merge two halves alternately.

---

## 📖 Problems Practiced
1. Sort Linked List (Merge Sort)
2. Reorder Linked List

---

## 🔑 Key Takeaways
- Merge Sort is **O(N log N)** for linked list.
- Reordering uses **middle + reverse + merge** trick.
- Both are **very popular interview problems**.

