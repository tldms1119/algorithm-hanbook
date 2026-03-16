/**
 * LeetCode #42 - Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Pattern: Two Pointers
 *
 * 🧠 Core Idea
 * Water trapped at position i depends on:
 * water[i] = min(leftMax, rightMax) - height[i]
 * leftMax  = highest bar seen from the left
 * rightMax = highest bar seen from the right
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 */
public class LC0042TrappingRainWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
