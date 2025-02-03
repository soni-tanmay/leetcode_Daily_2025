
//source: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/?envType=daily-question&envId=2025-02-03
class Solution {

    public static int longestMonotonicSubarray(int[] nums) {
        int maxInc = 0;
        int maxDec = 0;
        int countInc = 0;
        int countDec = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                countInc++;
            } else {
                maxInc = Math.max(maxInc, countInc);
                countInc = 0;
            }
            if (nums[i] > nums[i + 1]) {
                countDec++;
            } else {
                maxDec = Math.max(maxDec, countDec);
                countDec = 0;
            }
        }
        maxInc = Math.max(maxInc, countInc);
        maxDec = Math.max(maxDec, countDec);
        return Math.max(maxDec, maxInc) + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[] { 1, 4, 3, 3, 2 }));
    }
}
