
// source: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] target = new int[26];
        for (String word : words2) {
            int[] temp = createValues(word);
            for (int i = 0; i < 26; i++) {
                target[i] = Math.max(target[i], temp[i]);
            }
        }
        for (String word : words1) {
            int[] value = createValues(word);
            boolean contains = true;
            for (int i = 0; i < 26; i++) {
                if (value[i] < target[i]) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                ans.add(word);
            }
        }
        return ans;
    }

    public static int[] createValues(String word) {
        int[] temp = new int[26];
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            temp[i]++;
        }
        return temp;
    }

    public static void main(String[] args) {
        String[] word1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] word2 = { "eo", "lo" };
        System.out.println(wordSubsets(word1, word2));
    }
}
