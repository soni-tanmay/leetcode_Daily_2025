import java.util.HashMap;

class Solution {

    public static HashMap<Character, Integer> map = new HashMap<>();

    public static int consonants = 0;

    public static long countOfSubstrings(String word, int k) {
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        long count = 0;
        for (int i = 0; i < k + 5; i++) {
            if (map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            } else {
                consonants++;
            }
        }
        if (isValid(k)) {
            count++;
        }
        int l = 0;
        int r = k + 5;
        while (r < word.length() && l < word.length() - k - 5) {
            if (map.containsKey(word.charAt(r))) {
                map.put(word.charAt(r), map.get(word.charAt(r)) + 1);
            } else {
                consonants++;
            }
            r++;

            if (isValid(k)) {
                count++;
                continue;
            }

            if (map.containsKey(word.charAt(l))) {
                map.put(word.charAt(l), map.get(word.charAt(l)) - 1);
            } else {
                consonants--;
            }
            l++;
            r = l + k + 4;
            if (isValid(k)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isValid(int k) {
        if (map.getOrDefault('a', 0) > 0 && map.getOrDefault('e', 0) > 0 && map.getOrDefault('i', 0) > 0
                && map.getOrDefault('o', 0) > 0 && map.getOrDefault('u', 0) > 0 && consonants == k) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("iqeaouqi", 2));
    }
}