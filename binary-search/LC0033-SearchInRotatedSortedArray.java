/**
 * LeetCode #33 - Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Pattern: Binary Search (Rotated Array)
 *
 * 🧠 Core Idea
 * Even though the array is rotated, one side is always sorted.
 * Use this property to eliminate half of the search space.
 *
 * Approach
 * 1. Standard binary search
 * 2. Check which side is sorted
 * 3. Decide whether target is inside sorted half
 *
 * ⏱ Time Complexity: O(log n)
 * 💾 Space Complexity: O(1)
 */
public class LC0033SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // left side is sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // right side is sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
