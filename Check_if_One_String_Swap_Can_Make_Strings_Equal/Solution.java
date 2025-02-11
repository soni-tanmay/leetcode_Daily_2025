
//source: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/?envType=daily-question&envId=2025-02-05

public class Solution {
    public static boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int n = s1.length();
        int[] m = new int[26];
        for (int i = 0; i < n; i++) {
            m[s1.charAt(i) - 'a']++;
            m[s2.charAt(i) - 'a']--;
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        for (int k : m) {
            if (k != 0) {
                return false;
            }
        }
        return count < 3;
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
    }
}
