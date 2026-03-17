/**
 * LeetCode #84 - Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Pattern: Monotonic Stack
 *
 * 🧠 Core Idea
 * Maintain an increasing stack.
 * When current height is smaller than stack top,
 * pop from stack and calculate area (height * width)
 * width = rightBoundary - leftBoundary - 1
 *
 * Add a dummy 0 height at the end to force all elements to be processed.
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n)
 */
import java.util.*;

public class LC0084LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
              
                int width = right - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
