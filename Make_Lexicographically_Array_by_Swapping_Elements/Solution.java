import java.util.PriorityQueue;

public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] marked = new int[nums.length];
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 5, 3, 9, 8 };
        int limit = 2;
        int[] result = s.lexicographicallySmallestArray(nums, limit);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
