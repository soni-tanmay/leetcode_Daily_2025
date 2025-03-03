class Solution {

    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > 0) {
                sum = 0;
            }
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }

    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[] { 1, -3, 2, 3, -4 }));
    }
}
