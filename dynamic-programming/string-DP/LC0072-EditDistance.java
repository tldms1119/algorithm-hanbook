/**
 * LeetCode #72 - Edit Distance
 * https://leetcode.com/problems/edit-distance/
 *
 * Pattern: Dynamic Programming (2D DP)
 *
 * 🧠 DP State Definition
 *
 * dp[i][j]: word1의 앞 i글자를 word2의 앞 j글자로 만들 수 있는 최소 연산 수
 * Minimum edit distance between first i characters of word1 and first j characters of word2
 *
 * Base Cases
 * dp[0][j] = j   // insert all characters
 * dp[i][0] = i   // delete all characters
 *
 * Formula
 * dp[i][j] = if (word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1]
 *            else 1 + min(
 *                       dp[i-1][j],    // delete
 *                       dp[i][j-1],    // insert
 *                       dp[i-1][j-1]   // replace
 *                     )
 *
 * ⏱ Time Complexity: O(m × n)
 * 💾 Space Complexity: O(m × n)
 */
public class LC0072EditDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],        // delete
                            Math.min(
                                    dp[i][j - 1],    // insert
                                    dp[i - 1][j - 1] // replace
                            )
                    );
                }
            }
        }
        return dp[m][n];
    }
}
