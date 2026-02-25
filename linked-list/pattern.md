## Linked List Pattern

### 📌 When to Use
- Node manipulation
- In-place pointer re-wiring
- Merge / Reverse / Cycle detection

### 🧠 Core Idea
1. Dummy Node Pattern
   - Use a dummy head
   ```java
   ListNode dummy = new ListNode();
   ListNode current = dummy;
   ```
2. Two Pointer Traversal
   - Move pointers while comparing values
3. Fast & Slow Pointer
   - Used for cycle detection or middle finding

### ⏱ Typical Complexity
- Time: O(n)
- Space: O(1)
