// source: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2025-01-01

import java.util.ArrayList;

class Solution {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        ArrayList<int[]> res = new ArrayList<>();
        // int[][] res = new int[l1 + l2][2];
        int i = 0;
        int j = 0;
        // int k = 0;
        while (i < l1 && j < l2) {
            if (nums1[i][0] < nums2[j][0]) {
                res.add(new int[] { nums1[i][0], nums1[i][1] });
                // res[k][0] = nums1[i][0];
                // res[k][1] = nums1[i][1];
                i++;
                // k++;
            } else if (nums1[i][0] > nums2[j][0]) {
                res.add(new int[] { nums2[j][0], nums2[j][1] });

                // res[k][0] = nums2[j][0];
                // res[k][1] = nums2[j][1];
                j++;
                // k++;
            } else {
                res.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });

                // res[k][0] = nums1[i][0];
                // res[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
                // k++;
            }
        }

        while (i < l1) {
            res.add(new int[] { nums1[i][0], nums1[i][1] });

            // res[k][0] = nums1[i][0];
            // res[k][1] = nums1[i][1];
            i++;
            // k++;
        }

        while (j < l2) {
            res.add(new int[] { nums2[j][0], nums2[j][1] });

            // res[k][0] = nums2[j][0];
            // res[k][1] = nums2[j][1];
            j++;
            // k++;
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums1 = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] nums2 = new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        System.out.println(mergeArrays(nums1, nums2));
    }
}