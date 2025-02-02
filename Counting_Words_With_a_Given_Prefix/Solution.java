// source: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09
class Solution {
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (pref.length() <= words[i].length()) {
                if (words[i].startsWith(pref)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = { "pay", "attention", "practice", "attend" };
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }
}