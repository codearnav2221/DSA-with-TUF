# Day 18 – Rotate Linked List & Copy with Random Pointer

## ✅ What I Learned
### 1. Rotate Linked List
- Given `k`, rotate list to the right by `k` places.
- Key steps:
  1. Count length of list.
  2. Connect tail → head (make it circular).
  3. Break the circle at `(length - k % length)`.

### 2. Copy List with Random Pointer
- Each node has `next` and `random`.
- Naive: Use HashMap (old → new).
- Optimized:
  1. Clone nodes and insert them between originals.
  2. Fix random pointers.
  3. Separate cloned list from original.

---

## 📖 Problems Practiced
1. Rotate Linked List (k rotations)
2. Copy List with Random Pointer

---

## 🔑 Key Takeaways
- Rotation uses **circular list trick**.
- Random pointer copy is tricky but elegant with **O(1) space** solution.

