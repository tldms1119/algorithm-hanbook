/**
 * LeetCode #79 - Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Pattern: Backtracking (Grid DFS)
 *
 * 🧠 Core Idea
 * Try to match the word starting from each cell.
 * Use DFS to explore all possible paths.
 * Mark cell as visited during path, and restore it after backtracking.
 *
 * Approach (DFS + 가지치기 + 상태 복원)
 * 1. Iterate every cell as starting point
 * 2. DFS to match characters one by one
 * 3. Mark visited to avoid reuse
 * 4. Backtrack after exploration
 *
 * ⏱ Time Complexity: O(m * n * 4^L)
 * 💾 Space Complexity: O(L)
 */
public class LC0079WordSearch {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {

        // Base case
        if (index == word.length()) return true;

        // Boundary + mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        // Explore 4 directions
        boolean found =
                dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // backtrack

        return found;
    }
}
