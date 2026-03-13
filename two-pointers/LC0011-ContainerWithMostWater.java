/**
 * LeetCode #11 - Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Pattern: Two Pointers
 *
 * 🧠 Core Idea
 * Start with two pointers at both ends of the array.
 * At each step calculate the current container area, and move the pointer with the smaller height.
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 */
public class LC0011ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;

            int area = h * width;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
