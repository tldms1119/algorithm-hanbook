/**
 * LeetCode 53 - Maximum Subarray
 * 
 * Pattern: Kadane's Algorithm (Dynamic Programming optimization)
 * 
 * 🧠 Core Insight
 * At each position, decide whether to:
 * - Start a new subarray from current number
 * - Extend the previous subarray
 *
 * ⏱ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 */
class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
