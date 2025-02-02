
// source: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2025-01-04
import java.util.HashSet;

public class Solution {
    public static int countPalindromicSubsequence(String s) {
        HashSet<Character> doneChar = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!doneChar.contains(s.charAt(i))) {
                for (int j = s.length() - 1; j > i + 1; j--) {
                    HashSet<Character> middleChar = new HashSet<Character>();
                    if ((s.charAt(i) == s.charAt(j))) {
                        for (int k = i + 1; k < j; k++) {
                            if (!middleChar.contains(s.charAt(k))) {
                                count++;
                                middleChar.add(s.charAt(k));
                            }
                        }
                        doneChar.add(s.charAt(i));
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
    }
}
