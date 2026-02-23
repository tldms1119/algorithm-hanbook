## Graph Pattern

### 📌 When to Use
- Prerequisite relationships
- Dependency ordering
- Detect cycle in directed graph
- Scheduling problems

### 🧠 Use cases
- BFS (Kahn's Algorithm) - using indegree (level order traversal)
  ```
  1) Build adjacency list
  2) Compute indegree array
  3) Add nodes with indegree 0 to queue
  4) Process queue:
    - Remove first node from queue
    - Reduce indegree of neighbors
    - If neighbor indegree becomes 0, add to queue
  5) If processed count == total nodes → no cycle
  ```
- DFS (Cycle detection with visited states)

### ⏱ Typical Complexity
- Time: O(V + E)
- Space: O(V + E)
