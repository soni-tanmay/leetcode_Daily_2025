
// source: https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04

class Solution {

    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int currSum = 0;
        for (int i = 0; i < n - 1; i++) {
            currSum += nums[i];
            if (nums[i] >= nums[i + 1]) {
                sum = Math.max(sum, currSum);
                currSum = 0;
            }
        }
        if (currSum > 0) {
            sum = Math.max(sum, currSum + nums[n - 1]);
        } else {
            sum = Math.max(sum, nums[n - 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[] { 10, 20, 30, 5, 10, 50 }));
    }
}
