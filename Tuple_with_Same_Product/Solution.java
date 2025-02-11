
// source: https://leetcode.com/problems/tuple-with-same-product/?envType=daily-question&envId=2025-02-06
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = (nums[i] * nums[j]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            sum += e.getValue() > 1 ? (e.getValue() * (e.getValue() - 1) * 4) : 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
        System.out.println(tupleSameProduct(nums));
    }
}
