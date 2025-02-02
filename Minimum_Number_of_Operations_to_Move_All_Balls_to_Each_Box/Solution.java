// source: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06
// import java.util.ArrayList;

public class Solution {
    @SuppressWarnings("deprecation")
    public static int[] minOperations(String boxes) {
        final int n = boxes.length();
        final byte[] b = new byte[n];
        final int[] res = new int[n];
        int sum = 0, count = 0;
        boxes.getBytes(0, n, b, 0);
        for (int i = n - 1; i > 0; i--) {
            int bt = b[i] & 1;
            sum += i * bt;
            count += bt;
        }
        res[0] = sum;
        count -= (b[0] & 1);
        for (int i = 1; i < n; i++) {
            res[i] = sum -= count;
            count -= (b[i] & 1) << 1;
        }
        return res;
    }
    // public static int[] minOperations(String boxes) {
    // int[] result = new int[boxes.length()];
    // ArrayList<Integer> indexes = new ArrayList<Integer>();
    // for (int i = 0; i < boxes.length(); i++) {
    // if (boxes.charAt(i) == '1') {
    // indexes.add(i);
    // }
    // }
    // for (int i = 0; i < result.length; i++) {
    // for (int index : indexes) {
    // result[i] = result[i] + Math.abs(i - index);
    // }
    // }
    // return result;
    // }

    public static void main(String[] args) {
        int[] result = minOperations("110");
        for (int i : result) {
            System.out.println(i);
        }
    }
}
