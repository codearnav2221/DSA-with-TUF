# Day 27 – Swap Nodes in Pairs & Reverse Nodes in k-Group (Iterative)

## ✅ What I Learned
### 1. Swap Nodes in Pairs
- Problem: Given LL, swap every 2 adjacent nodes.
- Approaches:
  - Recursive: swap first 2, recurse on rest.
  - Iterative (better for interviews):
    - Use dummy node before head.
    - Swap in chunks of 2.

### 2. Reverse Nodes in k-Group (Iterative Review)
- Already solved recursive version earlier.
- Iterative approach:
  - Count nodes.
  - Use 3 pointers (pre, curr, nex) to reverse k nodes.
  - Move pre pointer forward, continue while count ≥ k.

---

## 📖 Problems Practiced
1. Swap nodes in pairs.
2. Reverse nodes in k-group (iterative).

---

## 🔑 Key Takeaways
- Pair swap = special case of k-group reversal with k=2.
- Iterative method avoids recursion stack → **O(1) extra space**.
- Group reversal is an interview **favorite (Amazon, Microsoft, Google)**.

