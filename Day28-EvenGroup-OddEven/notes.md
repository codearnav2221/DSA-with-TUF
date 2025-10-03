# Day 28 – Reverse Nodes in Even Length Groups & Odd-Even Linked List

## ✅ What I Learned
### 1. Reverse Nodes in Even Length Groups
- LL divided into groups of sizes 1,2,3,4,... 
- If group size is even → reverse that group, else keep same.
- Steps:
  1. Traverse group by group.
  2. Count actual size (last group may be shorter).
  3. If size is even → reverse that segment.
  4. Reconnect pointers carefully.

### 2. Odd-Even Linked List
- Problem: Group all odd-index nodes first, then even-index nodes.
- Steps:
  1. Keep two pointers: odd and even.
  2. Rearrange pointers while traversing.
  3. Finally link odd tail → even head.

---

## 📖 Problems Practiced
1. Reverse nodes in even length groups.
2. Odd-Even linked list.

---

## 🔑 Key Takeaways
- Even group reversal teaches careful **segment reversal**.
- Odd-even rearrangement is common in **array & LL** interviews.
- Both are great practice for **pointer manipulation**.
