public class Solution {
    public static int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;
        if (nums2.length % 2 == 1)
            for (int x : nums1) {
                result ^= x;
            }
        if (nums1.length % 2 == 1)
            for (int y : nums2) {
                result ^= y;
            }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, 3 }, nums2 = { 10, 2, 5, 0 };
        System.out.println(xorAllNums(nums1, nums2));
    }
}