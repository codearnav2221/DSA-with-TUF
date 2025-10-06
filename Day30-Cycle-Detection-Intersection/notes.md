# Day 30 – Detect & Remove Cycle, Find Intersection Point

## ✅ What I Learned

### 1️⃣ Detect Cycle (Floyd’s Cycle Detection)
- Use two pointers: **slow** and **fast**.
- Move `slow` by 1 step and `fast` by 2 steps.
- If they meet → cycle exists.
- If `fast` or `fast.next` becomes null → no cycle.

### 2️⃣ Find Start of Cycle
- After detection, set one pointer to head.
- Move both 1 step at a time → they meet at cycle start.

### 3️⃣ Remove Cycle
- Once start node is known:
  - Traverse from that node until `.next` = start node, then make `.next = null`.

### 4️⃣ Intersection of Two LLs
- Two LLs may intersect at a node.
- Find lengths of both LLs.
- Move the longer list's head forward by `diff`.
- Traverse both until they meet → intersection point.

---

## 📖 Problems Practiced
- [LeetCode 141](https://leetcode.com/problems/linked-list-cycle/)
- [LeetCode 142](https://leetcode.com/problems/linked-list-cycle-ii/)
- [LeetCode 160](https://leetcode.com/problems/intersection-of-two-linked-lists/)

---

## 🔑 Key Takeaways
- Floyd’s Algorithm → O(N) time, O(1) space.
- Intersection concept is about **aligning list lengths**.
- Must-know topics for **Amazon, Google, Meta, and Microsoft**.
