
//source: https://leetcode.com/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-02-09
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static long countBadPairs(int[] nums) {
        long n = nums.length;
        long tp = n * (n - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] + nums.length - i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            long k = e.getValue();
            if (k > 1) {
                tp -= (k * (k - 1) / 2);
            }
        }
        return tp;
    }

    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[] { 4, 1, 3, 3 }));
    }
}