
// source: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/?envType=daily-question&envId=2025-01-18
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int[] r : cost) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[] { 0, 0 });
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int r = cur[0], c = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dirs[dir][0];
                int nc = c + dirs[dir][1];
                int weight = (grid[r][c] != (dir + 1)) ? 1 : 0;
                if (isValid(nr, nc, m, n) &&
                        cost[r][c] + weight < cost[nr][nc]) {
                    cost[nr][nc] = cost[r][c] + weight;

                    // Add to back if cost=1, front if cost=0
                    if (weight == 1) {
                        deque.offerLast(new int[] { nr, nc });
                    } else {
                        deque.offerFirst(new int[] { nr, nc });
                    }
                }
            }

        }
        return cost[m - 1][n - 1];
    }

    private static boolean isValid(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 3 }, { 2, 2, 2 }, { 4, 4, 1 } };
        System.out.println(minCost(grid));
    }
}
