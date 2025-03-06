import java.util.HashSet;

class Solution {

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int a = 0;
        int b = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(grid[i][j])) {
                    a = grid[i][j];
                } else {
                    set.add(grid[i][j]);
                }
            }
        }

        for (int i = 1; i <= (n * n); i++) {
            if (!set.contains(i)) {
                b = i;
                break;
            }
        }
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3 }, { 2, 2 } };
        int[] res = findMissingAndRepeatedValues(grid);
        for (int r : res) {
            System.out.println(r);
        }
    }
}

// Optimized
// class Solution {

// public int[] findMissingAndRepeatedValues(int[][] grid) {
// long sum = 0, sqrSum = 0;
// long n = grid.length;
// long total = n * n;

// // Calculate actual sum and squared sum from grid
// for (int row = 0; row < n; ++row) {
// for (int col = 0; col < n; ++col) {
// sum += grid[row][col];
// sqrSum += (long) grid[row][col] * grid[row][col];
// }
// }

// // Calculate differences from expected sums
// // Expected sum: n(n+1)/2, Expected square sum: n(n+1)(2n+1)/6
// long sumDiff = sum - (total * (total + 1)) / 2;
// long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6;

// // Using math: If x is repeated and y is missing
// // sumDiff = x - y
// // sqrDiff = x² - y²
// int repeat = (int) (sqrDiff / sumDiff + sumDiff) / 2;
// int missing = (int) (sqrDiff / sumDiff - sumDiff) / 2;

// return new int[] { repeat, missing };
// }
// }