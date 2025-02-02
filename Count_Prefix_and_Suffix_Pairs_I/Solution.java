// source: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08
class Solution {
    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(str2.length() - str1.length() + i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = { "a", "aba", "ababa", "aa" };
        System.out.println(countPrefixSuffixPairs(words));
    }
}