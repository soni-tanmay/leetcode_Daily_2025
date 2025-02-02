// source: https://leetcode.com/problems/special-array-i/description/?envType=daily-question&envId=2025-02-01
class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new int[] { 4, 3, 1, 6 });
    }
}