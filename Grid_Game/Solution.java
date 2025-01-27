class Solution {
    public static long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] p1 = new long[n];
        long[] p2 = new long[n];
        p1[0] = grid[0][0];
        p2[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            p1[i] = p1[i - 1] + grid[0][i];
            p2[i] = p2[i - 1] + grid[1][i];
        }
        for (int i = 0; i < n; i++) {
            if (p2[i] >= (p1[n - 1] - p1[i])) {
                return Math.max((p1[n - 1] - p1[i]), i > 0 ? p2[i - 1] : 0);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                gridGame(new int[][] { { 10, 12, 14, 19, 19, 12, 19, 2, 17 }, { 20, 7, 17, 14, 3, 1, 1, 17, 12 } }));
    }
}
