// source: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/?envType=daily-question&envId=2025-02-07

import java.util.HashMap;

class Solution {

    public static int[] queryResults(int limit, int[][] queries) {
        int[] counter = new int[queries.length];
        int count = 0;
        HashMap<Integer, Integer> colors = new HashMap<>();
        HashMap<Integer, Integer> balls = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            if (balls.getOrDefault(q[0], 0) != 0) {
                int x = colors.get(balls.get(q[0])) - 1;
                colors.put(balls.get(q[0]), x);
                if (x == 0) {
                    count--;
                    colors.remove(colors.get(balls.get(q[0])));
                }
                balls.remove(q[0]);
            }
            if (colors.getOrDefault(q[1], 0) == 0 && balls.getOrDefault(q[0], 0) == 0) {
                count++;
            }

            balls.put(q[0], q[1]);
            colors.put(q[1], colors.getOrDefault(q[1], 0) + 1);
            counter[i] = count;
        }
        return counter;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 4 }, { 2, 5 }, { 1, 3 }, { 3, 4 } };
        int[] res = queryResults(4, graph);
        for (int r : res) {
            System.out.println(r);
        }
    }
}