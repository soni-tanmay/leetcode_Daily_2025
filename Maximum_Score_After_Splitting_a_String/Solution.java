// source: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2025-01-01
class Solution {
    public static int maxScore(String s) {
        // char[] ch = s.toCharArray();
        // int sum = 0;

        // for (int bi = 0; bi < s.length() - 1; bi++) {
        // int ts = 0;
        // for (int i = 0; i < s.length(); i++) {
        // if (i <= bi && ch[i] == '0') {
        // ts++;
        // }
        // if (i > bi && ch[i] == '1') {
        // ts++;
        // }
        // }
        // if (ts > sum) {
        // sum = ts;
        // }
        // }

        // return sum;

        // Optimized
        int n = s.length();
        int ons = 0;
        int curr = s.charAt(0) == '0' ? 1 : 0;
        int score = curr;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                curr++;
            } else {
                ons++;
                curr--;
            }
            if (curr > score) {
                score = curr;
            }
        }
        ons += s.charAt(n - 1) == '1' ? 1 : 0;

        return ons + score;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("1111"));
    }
}