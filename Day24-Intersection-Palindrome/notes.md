
# Day 24 – Intersection of Two Linked Lists & Palindrome Linked List

## ✅ What I Learned
### 1. Intersection of Two Linked Lists
- Problem: Given two singly linked lists, return the node where they intersect (or null).
- Approaches:
  - **HashSet**: store all nodes of one list, then check other.
  - **Length difference method**: move longer list ahead by diff, then traverse together.
  - **Two-pointer trick (most elegant)**:
    - Traverse both lists with two pointers.
    - When one reaches null, switch to the other head.
    - If they intersect → they will meet, else both null.

### 2. Palindrome Linked List
- Problem: Check if LL is a palindrome.
- Approaches:
  - **Convert to array** → O(n) space.
  - **Reverse second half** (optimal O(1) space):
    1. Find middle with slow/fast.
    2. Reverse second half.
    3. Compare first half & reversed second half.
    4. (Optional) Restore list.

---

## 📖 Problems Practiced
1. Intersection of two linked lists.
2. Palindrome linked list check.

---

## 🔑 Key Takeaways
- Intersection → two-pointer trick is very common in interviews.
- Palindrome → teaches you middle-finding, reversal, and comparison.
- Both are **Amazon / Microsoft / Google top favorites**.
