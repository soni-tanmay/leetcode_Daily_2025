// source: https://leetcode.com/problems/count-servers-that-communicate/description/?envType=daily-question&envId=2025-01-23
public class Solution {
    public long coloredCells(int n) {
        long r = (long) n;
        return (1 + (4 * r * (r - 1) / 2));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.coloredCells(1));
    }
}
