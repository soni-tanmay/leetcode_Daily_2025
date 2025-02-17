
// source: https://leetcode.com/problems/summary-ranges/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> anwList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            String anw = "";
            anw += nums[i];
            j = i + 1;
            while (j < nums.length) {
                if (nums[j] - nums[i] != j - i) {
                    j--;
                    break;
                }
                j++;
            }
            if (j == nums.length) {
                j--;
            }
            if (j > i && j < nums.length) {
                anw += "->" + nums[j];
            }
            i = j + 1;
            anwList.add(anw);
        }
        return anwList;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
        for (String s : summaryRanges(nums)) {
            System.out.println(s);
        }
    }
}
