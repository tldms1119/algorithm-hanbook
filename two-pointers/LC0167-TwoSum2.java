/**
 * LeetCode #167 - Two Sum II - Input Array Is Sorted
 *
 * 🧠 Core Insight (Two Pointer Pattern)
 *
 * Since the array is sorted:
 * - If sum < target → move left pointer right (increase sum)
 * - If sum > target → move right pointer left (decrease sum)
 *
 * ⏱ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 *
 * 🔥 Pattern Recognition Signal
 *
 * If problem says:
 * - "sorted array"
 * - "find pair"
 * - "exactly one solution"
 *
 * → Think: Two Pointers from both ends
 */

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } 
            else if (sum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
