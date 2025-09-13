# Day 16 – Delete Middle Node & Intersection of Linked Lists

## ✅ What I Learned
### 1. Delete Middle Node
- Use slow & fast pointers to find the middle node.
- Keep track of the previous node so that `prev.next = slow.next` removes middle.
- Edge case: if only one node, return `null`.

### 2. Intersection of Linked Lists
- Naive: Use HashSet → O(n+m) space.
- Optimized: Two-pointer approach:
  - Traverse both lists with two pointers.
  - When a pointer reaches the end, redirect it to the head of the other list.
  - They will meet at intersection (or null if no intersection).

---

## 📖 Problems Practiced
1. Delete Middle Node of LL
2. Intersection Point of Two Linked Lists

---

## 🔑 Key Takeaways
- Deleting middle is a variation of “find middle” (slow & fast pointers).
- Intersection problem is **LeetCode 160**, very common in interviews.
- Two-pointer trick avoids extra space and runs in O(n+m).

