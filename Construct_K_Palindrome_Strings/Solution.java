//source: https://leetcode.com/problems/construct-k-palindrome-strings/description/?envType=daily-question&envId=2025-01-11
public class Solution {
    public static boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        if (s.length() == k)
            return true;
        int[] value = new int[26];
        for (char c : s.toCharArray()) {
            value[c - 'a']++;
        }
        int count = 0;
        for (int v : value) {
            if (v % 2 != 0) {
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));
    }
}
