/**
 * LeetCode #5 - Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Pattern: Expand Around Center
 *
 * 🧠 Core Idea
 * A palindrome expands from its center.
 * Try all possible centers (odd + even) and expand.
 *
 * Approach
 * 1. Iterate each index as center
 * 2. Expand for:
 *    - odd length (i, i)
 *    - even length (i, i+1)
 * 3. Track longest substring
 *
 * ⏱ Time Complexity: O(n^2)
 * 💾 Space Complexity: O(1)
 */
public class LC0005LongestPalindromicSubstring {

    private int start = 0;
    private int maxLen = 0;

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) return s;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // odd
            expand(s, i, i + 1);   // even
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }

            left--;
            right++;
        }
    }
}
