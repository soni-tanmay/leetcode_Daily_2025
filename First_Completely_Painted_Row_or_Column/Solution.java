
// source: https://leetcode.com/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2025-01-20
import java.util.HashMap;

class Solution {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        int[][] checkMat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }
        for (int a : arr) {
            int i = map.get(a)[0], j = map.get(a)[1];
            checkMat[i][j]++;
            count++;
            if (isPainted(checkMat, i, j)) {
                return count - 1;
            }
        }
        return 0;
    }

    public static boolean isPainted(int[][] checkMat, int i, int j) {
        boolean row = true;
        for (int x = 0; x < checkMat.length; x++) {
            if (checkMat[x][j] != 1) {
                row = false;
                break;
            }
        }
        boolean col = true;
        for (int x = 0; x < checkMat[0].length; x++) {
            if (checkMat[i][x] != 1) {
                col = false;
                break;
            }
        }
        return row || col;
    }
    // Optimized
    // class Solution {
    // public int firstCompleteIndex(int[] arr, int[][] mat) {
    // int[] map = new int[arr.length + 1];
    // for (int i = 0; i < arr.length; i++) {
    // map[arr[i]] = i;
    // }
    // int ans = Integer.MAX_VALUE;
    // for (int i = 0; i < mat.length; i++) {
    // int max = 0;
    // for (int j = 0; j < mat[i].length; j++) {
    // max = Math.max(max, map[mat[i][j]]);
    // }
    // ans = Math.min(ans, max);
    // }
    // for (int i = 0; i < mat[0].length; i++) {
    // int max = 0;
    // for (int j = 0; j < mat.length; j++) {
    // max = Math.max(max, map[mat[j][i]]);
    // }
    // ans = Math.min(ans, max);
    // }
    // return ans;
    // }
    // }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2 };
        int[][] mat = { { 1, 4 }, { 2, 3 } };
        int res = firstCompleteIndex(arr, mat);
        System.out.println(res);
    }
}