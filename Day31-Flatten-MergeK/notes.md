# Day 31 – Flatten a Linked List & Merge K Sorted Lists

## ✅ What I Learned

### 1️⃣ Flatten a Linked List
- Each node has two pointers:
  - `next` → right side
  - `bottom` → down side (sorted)
- Goal: merge all lists into one **sorted single list**.
- Approach:
  - Recursively flatten right list.
  - Merge current list with flattened right.

### 2️⃣ Merge K Sorted Linked Lists
- We are given an array of K sorted LLs.
- Approaches:
  - **Min-Heap** (Priority Queue): O(N log K)
  - **Divide & Conquer** (merge two at a time)
- Very common in interviews.

---

## 📖 Problems Practiced
- [LeetCode 23](https://leetcode.com/problems/merge-k-sorted-lists/)
- GFG: Flattening a Linked List

---

## 🔑 Key Takeaways
- Flattening is essentially **merging sorted lists**.
- Heap gives the most efficient solution for K lists.
- Divide & Conquer simplifies code without extra space.
