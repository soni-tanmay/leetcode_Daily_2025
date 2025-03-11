import java.util.HashMap;

public class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int start = 0;
        int end = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char ech = s.charAt(end);
            if (isValid(ech)) {
                map.put(ech, map.getOrDefault(ech, 0) + 1);
            }

            while (map.keySet().size() == 3) {
                count += s.length() - end;
                char sch = s.charAt(start);
                if (isValid(sch)) {
                    map.put(sch, map.getOrDefault(sch, 0) - 1);
                    if (map.get(sch) < 1) {
                        map.remove(sch);
                    }
                }
                start++;
            }
            end++;
        }

        return count;
    }

    public boolean isValid(char c) {
        return (c == 'a' || c == 'b' || c == 'c');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("abcabc"));
    }
}

// Optimized
// class Solution {

// public int numberOfSubstrings(String s) {
// int len = s.length();
// // Track last position of a, b, c
// int[] lastPos = { -1, -1, -1 };
// int total = 0;

// for (int pos = 0; pos < len; pos++) {
// // Update last position of current character
// lastPos[s.charAt(pos) - 'a'] = pos;

// // Add count of valid substrings ending at current position
// // If any character is missing, min will be -1
// // Else min gives leftmost required character position
// total += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
// }

// return total;
// }
// }