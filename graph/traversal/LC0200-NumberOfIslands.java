/**
 * LeetCode #200 - Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * Pattern: Graph Traversal (DFS)
 * 
 * 🧠 Core Insight
 * 1. Iterate through every cell.
 * 2. If cell is '1':
 *      - increment island count
 *      - run DFS to mark entire island as visited
 * 3. Continue scanning.
 *
 * ⏱ Time Complexity: O(m × n)
 * 💾 Space Complexity: O(m × n)
 */

public class LC0200NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {

        int rows = grid.length;
        int cols = grid[0].length;

        // boundary or water check
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // mark visited
        grid[r][c] = '0';

        // explore 4 directions
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
