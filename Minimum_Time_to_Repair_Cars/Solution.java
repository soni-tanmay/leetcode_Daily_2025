import java.util.Arrays;

public class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minValue = 1;
        long maxValue = Arrays.stream(ranks).max().getAsInt() * cars * cars;
        System.out.println(maxValue);
        int l = ranks.length;
        while (minValue < maxValue) {
            long midValue = (minValue + maxValue) / 2;
            int possibleRepairs = 0;
            for (int i = 0; i < l; i++) {
                possibleRepairs += (int) Math.sqrt(midValue / ranks[i]);
            }

            if (possibleRepairs < cars) {
                minValue = midValue + 1;
            } else {
                maxValue = midValue;
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repairCars(new int[] { 4, 2, 3, 1 }, 10));
    }
}
