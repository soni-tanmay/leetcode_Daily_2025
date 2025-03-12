class Solution {
    public int maximumCount(int[] nums) {
        int length = nums.length;
        int neg = 0;
        int zero = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] == 0) {
                zero++;
            } else {
                break;
            }
        }
        return Math.max((length - neg - zero), neg);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumCount(new int[] { -2, -1, -1, 1, 2, 3 }));
    }
}
