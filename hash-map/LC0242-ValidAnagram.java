/**
 * LeetCode #242 - Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Pattern: Hash Map / Frequency Counting
 * 
 * 🧠 Core Insight
 * Count frequency of each character in s, then subtract using characters from t.
 * If all counts end at zero → valid anagram.
 * 
 * ⏱ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 */
public class LC0242ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
