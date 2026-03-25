/**
 * LeetCode #139 - Word Break
 * https://leetcode.com/problems/word-break/
 *
 * Pattern: Dynamic Programming (String Segmentation)
 *
 * 🧠 Core Idea
 * dp[i] means whether substring(0, i) can be segmented.
 * For each i, check if substring(0, j) & substring(j, i) is in dictionary (j < i) => dp[i] = true
 *
 * Approach
 * 1. Convert wordDict to HashSet
 * 2. Initialize dp[0] = true
 * 3. For each i, try all possible splits
 *
 * ⏱ Time Complexity: O(n^2)
 * 💾 Space Complexity: O(n)
 */
import java.util.*;

public class LC0139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
