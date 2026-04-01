## Backtracking Pattern

### 📌 When to Use
- Explore all possible cases
- Path depends on previous choices
- Need to avoid revisiting same cell in one path

### 🧠 Core Idea
- Start DFS from each possible cell
- Explore 4 directions (up, down, left, right)
- Mark visited during path exploration
- Backtrack after recursion (!important)

### ⚠️ Key Techniques
- Use visited marking (boolean[][] or modify grid)
- Backtrack (restore state after DFS)
- Prune early if condition fails

### 📄 Template
```java
for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        if (dfs(i, j, ...)) return true;
    }
}

boolean dfs(int i, int j, ...) {
    // base condition
    mark visited;
    for (dir in directions) {
        if (dfs(next_i, next_j, ...)) return true;
    }
    backtrack (unmark);
    return false;
}
```

### ⏱ Typical Complexity
- Time: O(m * n * 4^L)
- Space: O(L) recursion stack
