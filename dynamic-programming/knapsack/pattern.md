## Knapsack Pattern (0/1 Knapsack)

### 📌 When to Use
- Choose or not choose each item
- Subset / combination problems
- Maximize or check achievable value
- Constraints like "each item can be used once"

### 🧠 Core Idea
- For each item, choose between "take it" or "skip it"

- #### DP State (Classic)
  - dp[i][w] : Whether we can achieve weight/value `w` using first `i` items
            or Maximum weight/value when the capacity is `w` using first `i` items 

- #### Space Optimized State (Most Common)
  - dp[w] : Whether weight/value `w` is achievable
         or Maximum weight/value when the capacity is `w`
  - ```
    for each item:
        for w from capacity down to itemWeight: (backward!)
            dp[w] = dp[w] OR dp[w - itemWeight]
    ```
  - why backward?
    - To avoid dupicated choice of each item
    - Forward iteration turns it into Unbounded(∞) Knapsack


### ⏱ Typical Complexity
- Time: O(n * capacity)
- Space: O(capacity)
