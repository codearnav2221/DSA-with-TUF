# Day 26 – Reorder List & Rotate List

## ✅ What I Learned
### 1. Reorder List
- Problem: Given LL `L0 → L1 → … → Ln-1 → Ln`,
  reorder to `L0 → Ln → L1 → Ln-1 → L2 → Ln-2 …`.
- Steps:
  1. Find middle of list.
  2. Reverse second half.
  3. Merge first half and reversed second half.

### 2. Rotate List
- Problem: Given LL and integer k, rotate list right by k.
- Steps:
  1. Find length.
  2. Make list circular.
  3. Break at new head = (len - k % len)th node.

---

## 📖 Problems Practiced
1. Reorder list.
2. Rotate list by k.

---

## 🔑 Key Takeaways
- Both are **classic transformations** involving:
  - Middle-finding.
  - Reversal.
  - Reconnecting pointers.
- Very popular in FAANG interviews.

