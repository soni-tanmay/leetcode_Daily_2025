/*
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * The test cases are generated such that the number of unique combinations that
 * sum up to target is less than 150 combinations for the given input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * 
 * Input: candidates = [2], target = 1
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int sum = target;
        for (int c : candidates) {
            set.add(c);
        }
        for (int i = 0; i < candidates.length; i++) {
            while (sum >= candidates[i]) {
                sum -= candidates[i];
                System.out.println(sum);
                current.add(candidates[i]);
                if (set.contains(sum)) {
                    System.out.println("here");
                    current.add(sum);
                    result.add(current);
                }
            }
            current = new ArrayList<>();
            sum = target;
        }
        // backtrack(result, current, candidates, target, 0);
        return result;
    }

    // private void backtrack(List<List<Integer>> result, List<Integer> current,
    // int[] candidates, int target, int start) {
    // if (target == 0) {
    // result.add(new ArrayList<>(current));
    // return;
    // }

    // for (int i = start; i < candidates.length; i++) {
    // if (candidates[i] <= target) {
    // current.add(candidates[i]);
    // backtrack(result, current, candidates, target - candidates[i], i);
    // current.remove(current.size() - 1);
    // }
    // }
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(s.combinationSum(candidates, target));
    }
}