// source: https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/?envType=daily-question&envId=2025-01-28

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static class Cell {
        int v;
        int i;
        int j;

        public Cell(int v, int i, int j) {
            this.v = v;
            this.i = i;
            this.j = j;
        }
    }

    private static final int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    max = Math.max(max, totalFish(i, j, grid, visited));
                }
            }
        }
        return max;
    }

    public static int totalFish(int i, int j, int[][] grid, boolean[][] visited) {
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(grid[i][j], i, j));
        visited[i][j] = true;
        int countFish = 0;
        int m = grid.length;
        int n = grid[0].length;

        while (!q.isEmpty()) {
            Cell curr = q.poll();
            countFish += curr.v;
            for (int[] d : dir) {
                int ni = curr.i + d[0];
                int nj = curr.j + d[1];

                if (ni < m && ni >= 0 && nj < n && nj >= 0 && grid[ni][nj] != 0 && !visited[ni][nj]) {
                    q.offer(new Cell(grid[ni][nj], ni, nj));
                    visited[ni][nj] = true;
                }
            }
        }
        return countFish;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 8, 6 },
                { 2, 6 },
        };
        System.out.println(findMaxFish(grid));
    }
}
