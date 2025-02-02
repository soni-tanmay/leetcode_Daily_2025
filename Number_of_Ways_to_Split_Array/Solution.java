// source: https://leetcode.com/problems/number-of-ways-to-split-array/description/?envType=daily-question&envId=2025-01-03
public class Solution {
    public static int waysToSplitArray(int[] nums) {
        int l = nums.length;
        long[] prefix = new long[l];
        prefix[0] = nums[0];
        for (int i = 1; i < l; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < l - 1; i++) {
            long lsum = prefix[i];
            long rsum = prefix[l - 1] - prefix[i];
            if (lsum >= rsum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 4, -8, 7 };
        System.out.println(waysToSplitArray(nums));
    }
}
