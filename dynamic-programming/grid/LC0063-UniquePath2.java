/**
 * LeetCode #63 - Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * Pattern: Dynamic Programming (Grid DP)
 *
 * 🧠 Core Idea
 * Similar to Unique Paths I, but with obstacles.
 * If a cell has an obstacle, no paths can go through it.
 *
 * Each cell accumulates paths from:
 * - top (i-1, j)
 * - left (i, j-1)
 * If obstacle → set to 0
 *
 * ⏱ Time Complexity: O(m * n)
 * 💾 Space Complexity: O(m * n)
 */
public class LC0063UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // Start cell
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
