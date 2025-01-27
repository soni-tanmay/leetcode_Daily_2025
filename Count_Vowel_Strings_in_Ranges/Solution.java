public class Solution {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int size = words.length;
        int[] tally = new int[size + 1];
        for (int i = 0; i < size; i++) {
            String str = words[i];
            int l = str.length();
            char s = str.charAt(0);
            char e = str.charAt(l - 1);
            tally[i + 1] = tally[i];
            if ((s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u')
                    && (e == 'a' || e == 'e' || e == 'i' || e == 'o' || e == 'u')) {
                tally[i + 1]++;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = tally[queries[i][1] + 1] - tally[queries[i][0]];
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "aba", "bcb", "ece", "aa", "e" };
        int[][] queries = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
        int[] ans = vowelStrings(words, queries);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
