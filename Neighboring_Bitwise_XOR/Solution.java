//source: https://leetcode.com/problems/neighboring-bitwise-xor/description/?envType=daily-question&envId=2025-01-17
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for (int d : derived) {
            sum ^= d;
        }
        return sum == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().doesValidArrayExist(new int[] { 1, 0 }));
    }
}