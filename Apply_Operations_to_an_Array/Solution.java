class Solution {

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int writeIndex = 0;

        for (int index = 0; index < n; index++) {
            if (index < n - 1 &&
                    nums[index] == nums[index + 1] &&
                    nums[index] != 0) {
                nums[index] *= 2;
                nums[index + 1] = 0;
            }

            if (nums[index] != 0) {
                if (index != writeIndex) {
                    int temp = nums[index];
                    nums[index] = nums[writeIndex];
                    nums[writeIndex] = temp;
                }
                writeIndex++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 1, 0 };
        int[] res = new Solution().applyOperations(nums);
        for (int r : res) {
            System.out.println(r);
        }
    }
}