// source: https://leetcode.com/problems/count-servers-that-communicate/description/?envType=daily-question&envId=2025-01-23
public class Solution {
    public int countServers(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rcounts = new int[m];
        int[] ccounts = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rcounts[i]++;
                    ccounts[j]++;
                    count++;
                }
            }
        }
        System.out.println(count);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rcounts[i] == 1 && ccounts[j] == 1 && grid[i][j] == 1) {
                    count--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = new int[][] { { 1, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 } };
        System.out.println(sol.countServers(grid));
    }
}
