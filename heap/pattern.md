## Heap (Priority Queue) Pattern

### 📌 When to Use
- Top K problems
- Largest / Smallest K elements
- Need dynamic ordering
- Frequent elements problems

### 🧠 Core Idea
- Count frequency using HashMap
- Use Min-Heap (size k)

### 📄 Template
```java
PriorityQueue<int[]> minHeap = 
    new PriorityQueue<>((a, b) -> a[1] - b[1]);

for (entry : map) {
    heap.offer(/* ... */);
    if (heap.size() > k) {
        heap.poll();
    }
}
```

### ⏱ Typical Complexity
- Time: O(n log k)
- Space: O(n)
