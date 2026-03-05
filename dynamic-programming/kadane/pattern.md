## Maximum Subarray (Kadane's Algorithm)

### 📌 When to Use
- Finding **maximum sum contiguous subarray**
- Asking for **best subarray sgement**

### 🧠 Core Idea
At each index, decide whether to **extend the previous subarray** or **start a new subarray**

### 📄 Template
```java
currentMax = Math.max(num, currentMax + num); // (start new, extend previous)
globalMax = Math.max(globalMax, currentMax);
```

### ⏱ Typical Complexity
- Time: O(n)
- Space: O(1)
