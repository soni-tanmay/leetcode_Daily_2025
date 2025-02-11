//source: https://leetcode.com/problems/construct-k-palindrome-strings/description/?envType=daily-question&envId=2025-01-11
public class Solution {
    public static String clearDigits(String s) {
        int[] mark = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                mark[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (Character.isLetter(s.charAt(j)) && mark[j] != 1) {
                        mark[j] = 1;
                        break;
                    }
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (mark[i] != 1) {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
    }
}
