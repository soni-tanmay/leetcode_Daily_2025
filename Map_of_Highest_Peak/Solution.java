import java.util.PriorityQueue;

public class Solution {
    public static class Cell implements Comparable<Cell> {
        int v;
        int i;
        int j;

        Cell(int v, int i, int j) {
            this.v = v;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.v, o.v);
        }
    }

    public static final int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int[][] highestPeak(int[][] isWater) {
        PriorityQueue<Cell> q = new PriorityQueue<>();
        int m = isWater.length, n = isWater[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = isWater[i][j];
                if (v == 1) {
                    isWater[i][j] = 0;
                    q.offer(new Cell(isWater[i][j], i, j));
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Cell c = q.poll();
            for (int k = 0; k < 4; k++) {
                int i = c.i + d[k][0];
                int j = c.j + d[k][1];
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    isWater[i][j] = c.v + 1;
                    q.offer(new Cell(isWater[i][j], i, j));
                    visited[i][j] = true;
                }
            }
        }
        return isWater;
    }

    public static void main(String[] args) {
        int[][] isWater = { { 0, 1 }, { 0, 0 } };
        int[][] result = highestPeak(isWater);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
