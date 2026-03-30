## Binary Search Pattern

### 📌 When to Use
- Search in sorted or partially sorted data
- Need O(log n) time complexity
- Monotonic condition (increasing / decreasing)
- Decision boundary problems (first/last occurrence)

### 🧠 Core Idea
- Repeatedly divide search space in half
- Use condition to eliminate half each iteration
- Maintain valid search boundaries

### 📄 Template
```java
int left = 0, right = n - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

### ⏱ Typical Complexity
- Time: O(log n)
- Space: O(1)
