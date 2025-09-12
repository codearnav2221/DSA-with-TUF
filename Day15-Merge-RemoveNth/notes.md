# Day 15 – Merge Sorted Linked Lists & Remove Nth Node

## ✅ What I Learned
### 1. Merge Two Sorted Linked Lists
- Use two pointers (`l1`, `l2`) and build a new list by choosing smaller values.
- Can be done iteratively or recursively.

### 2. Remove N-th Node from End
- Use a dummy node before head.
- First move a fast pointer `n` steps.
- Then move both fast & slow until fast reaches end → slow.next is the node to remove.

---

## 📖 Problems Practiced
1. Merge Two Sorted Linked Lists
2. Remove N-th Node from End of List

---

## 🔑 Key Takeaways
- Merging lists is the foundation of **merge sort on LL**.
- Dummy node technique simplifies edge cases.
- N-th node removal is a classic **two-pointer** problem.

