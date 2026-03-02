/**
 * LeetCode #416 - Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Pattern: Dynamic Programming - 0/1 Knapsack
 *
 * 🧠 Core Insight
 *
 * Let totalSum = sum(nums)
 * If totalSum is odd → impossible
 * Otherwise:
 * Target = totalSum / 2
 *
 * Problem becomes:
 * "Can we pick some elements whose sum equals target?"
 * → This is exactly a 0/1 Knapsack feasibility problem.
 *
 * ≝ DP Definition
 * dp[w] = true if some subset can achieve sum w
 * For each num:
 *   for w from target down to num:
 *       dp[w] = dp[w] || dp[w - num]
 *
 * ⏱ Time Complexity: O(n × target)
 * 💾 Space Complexity: O(target)
 */
public class LC0416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;

        // If sum is odd, cannot split evenly
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            // backward iteration is critical
            for (int w = target; w >= num; w--) {
                dp[w] = dp[w] || dp[w - num];
            }
        }

        return dp[target];
    }
}
