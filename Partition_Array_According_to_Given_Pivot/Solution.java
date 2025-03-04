class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int index = 0;
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[index++] = nums[i];
            }
            if (nums[i] == pivot) {
                p++;
            }
        }
        while (p > 0) {
            res[index++] = pivot;
            p--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                res[index++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().pivotArray(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10);
    }
}