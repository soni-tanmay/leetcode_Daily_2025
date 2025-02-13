// source: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/?envType=daily-question&envId=2025-02-13

import java.util.PriorityQueue;

public class Solution {
    public static int minOperations(int[] nums, int k) {
        int operations = 0;
        PriorityQueue<Long> q = new PriorityQueue<Long>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            q.offer(Long.valueOf(nums[i]));
        }
        while (!q.isEmpty()) {
            Long f = q.poll();
            if (f >= k || q.isEmpty()) {
                break;
            }
            Long s = q.poll();

            operations++;
            Long z = Math.min(f, s) * 2 + Math.max(f, s);
            q.offer(z);
        }

        return operations;
    }

    public static void main(String[] args) {
        System.out.println(
                minOperations(new int[] { 1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999 },
                        1000000000));
    }
}
