// source: https://leetcode.com/problems/course-schedule-iv/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        for (int[] edge : prerequisites) {
            isPrerequisite[edge[0]][edge[1]] = true;
        }

        for (int intermediate = 0; intermediate < numCourses; intermediate++) {
            for (int src = 0; src < numCourses; src++) {
                for (int target = 0; target < numCourses; target++) {
                    isPrerequisite[src][target] = isPrerequisite[src][target] ||
                            (isPrerequisite[src][intermediate] &&
                                    isPrerequisite[intermediate][target]);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(isPrerequisite[query[0]][query[1]]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        int[][] queries = { { 0, 1 }, { 1, 0 } };
        List<Boolean> result = s.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result);
    }
}