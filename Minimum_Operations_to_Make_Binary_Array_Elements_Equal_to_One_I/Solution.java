class Solution {
    public int minOperations(int[] nums) {
        int op = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                flip(nums, i);
                flip(nums, i + 1);
                flip(nums, i + 2);
                op++;
            }
        }
        if (nums[nums.length - 2] == 0 || nums[nums.length - 1] == 0) {
            return -1;
        }
        return op;
    }

    public static void flip(int[] nums, int index) {
        if (nums[index] == 0)
            nums[index] = 1;
        else
            nums[index] = 0;
    }
}