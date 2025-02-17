
// source: https://leetcode.com/problems/word-pattern/description/

import java.util.HashMap;

class Solution {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] sarr = s.split(" ");
        char[] carr = pattern.toCharArray();
        if (sarr.length != carr.length) {
            return false;
        }
        for (int i = 0; i < sarr.length; i++) {
            if (map1.containsKey(carr[i])) {
                if (!map1.get(carr[i]).equals(sarr[i])) {
                    return false;
                }
            } else {
                map1.put(carr[i], sarr[i]);
            }

            if (map2.containsKey(sarr[i])) {
                if (!map2.get(sarr[i]).equals(carr[i])) {
                    return false;
                }
            } else {
                map2.put(sarr[i], carr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
