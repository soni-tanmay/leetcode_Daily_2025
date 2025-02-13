
// source: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/?envType=daily-question&envId=2025-02-12

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int maximumSum(int[] nums) {
        int max = -1;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int ds = digitSum(nums[i]);
            ArrayList<Integer> list = map.getOrDefault(ds, new ArrayList<>());
            list.add(nums[i]);
            map.put(ds, list);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            int n = e.getValue().size();
            if (n > 1) {
                max = Math.max(max, (e.getValue().get(n - 1) + e.getValue().get(n - 2)));
            }
        }
        return max;
    }

    public static int digitSum(int num) {
        int sum = 0;
        String str = "" + num;
        String[] arr = str.split("");
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] { 18, 43, 36, 13, 7 }));
    }
}
// Optimized
// class Solution {

// public int maximumSum(int[] nums) {
// int result = -1;
// // Array to map digit sums to the largest element with that sum
// // (82 to cover all possible sums from 0 to 81)
// int[] digitMapping = new int[82];

// for (int element : nums) {
// int digitSum = 0;
// // Calculating digit sum
// for (int currValue = element; currValue != 0; currValue /= 10) {
// int currDigit = currValue % 10;
// digitSum += currDigit;
// }

// // Check if there is already an element with the same digit sum
// if (digitMapping[digitSum] > 0) {
// // Update the result if the sum of the current and mapped element is greater
// result = Math.max(result, digitMapping[digitSum] + element);
// }

// // Update the mapping to store the larger of the current or previous element
// for this digit sum
// digitMapping[digitSum] = Math.max(digitMapping[digitSum], element);
// }

// return result;
// }
// }