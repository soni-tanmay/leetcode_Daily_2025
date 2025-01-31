// source: https://leetcode.com/problems/making-a-large-island/description/?envType=daily-question&envId=2025-01-31

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class Cell {
        int i;
        int j;
        int v;

        Cell(int v, int i, int j) {
            this.i = i;
            this.j = j;
            this.v = v;
        }
    }

    public static final int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        Cell[][] root = new Cell[n][n];
        HashMap<Cell, Integer> map = new HashMap<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        ArrayList<Cell> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    Cell c = new Cell(1, i, j);
                    int count = islandCount(grid, c, visited, root);
                    map.put(c, count);
                } else if (grid[i][j] == 0) {
                    list.add(new Cell(0, i, j));
                }
            }
        }

        if (list.isEmpty()) {
            return n * n;
        } else {
            int max = 0;
            for (Cell curr : list) {
                int sum = 0;
                ArrayList<Cell> sumList = new ArrayList<>();
                for (int d = 0; d < dir.length; d++) {
                    int ni = curr.i + dir[d][0];
                    int nj = curr.j + dir[d][1];

                    if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid.length && grid[ni][nj] == 1) {
                        if (!sumList.contains(root[ni][nj])) {
                            sum += map.get(root[ni][nj]);
                            sumList.add(root[ni][nj]);
                        }

                    }
                }
                max = Math.max(max, sum);
            }
            return max + 1;
        }
    }

    public static int islandCount(int[][] grid, Cell c, boolean[][] visited, Cell[][] root) {
        int count = 0;

        Queue<Cell> q = new LinkedList<Cell>();

        q.offer(c);
        visited[c.i][c.j] = true;
        root[c.i][c.j] = c;
        count++;

        while (!q.isEmpty()) {
            Cell curr = q.poll();

            for (int d = 0; d < dir.length; d++) {
                int ni = curr.i + dir[d][0];
                int nj = curr.j + dir[d][1];

                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid.length && grid[ni][nj] == 1
                        && !visited[ni][nj]) {
                    q.offer(new Cell(grid[ni][nj], ni, nj));
                    visited[ni][nj] = true;
                    root[ni][nj] = c;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][] { { 1, 1 }, { 0, 1 } }));
    }
}
