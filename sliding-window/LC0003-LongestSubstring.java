/**
 * LeetCode #3 - Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 🧠 Core Insight (Sliding Window)
 *
 * Use two pointers (left, right) to maintain a window representing a substring of s with distinct characters
 *
 * ⏱ Time Complexity: O(n)
 * 💾 Space Complexity: O(min(n, charset))
 */

import java.util.HashSet;
import java.util.Set;

public class LC0003LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // shrink window until `set` doesn't have duplicated character
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Record/update `set`
            set.add(c);

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
