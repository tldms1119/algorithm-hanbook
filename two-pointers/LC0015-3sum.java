/**
 * LeetCode #15 - 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Pattern: Two Pointers + Sorting
 *
 * 🧠 Core Idea
 * Sort the array, then fix one number.
 * Use two pointers to find pairs that sum to -nums[i].
 *
 * !Key challenge is handling duplicates.
 *
 * Approach
 * 1. Sort the array
 * 2. Fix index i
 * 3. Use left/right pointers to find pairs
 * 4. Skip duplicates for i, left, right
 *
 * ⏱ Time Complexity: O(n^2)
 * 💾 Space Complexity: O(1) (excluding result)
 */
import java.util.*;

public class LC0015ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
