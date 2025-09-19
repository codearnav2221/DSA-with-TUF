# Day 21 – Detect Cycle & Remove N-th Node from End

## ✅ What I Learned
### 1. Detect Cycle in Linked List
- Use **Floyd’s Cycle Detection (Tortoise & Hare)**.
- If slow == fast → cycle exists.
- To find cycle start:
  1. Reset one pointer to head.
  2. Move both by 1 step.
  3. Where they meet = cycle start.

### 2. Remove N-th Node from End
- Use **two-pointer method**:
  - Move `fast` n steps ahead.
  - Move both slow & fast until fast reaches end.
  - Remove `slow.next`.

---

## 📖 Problems Practiced
1. Detect cycle existence
2. Find cycle start node
3. Remove N-th Node from End

---

## 🔑 Key Takeaways
- Cycle detection = **Floyd’s algorithm**.
- Removing N-th from end = **two-pointer pattern**.
- Both are **high-frequency interview questions**.

