import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i]) && !answer.contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        String[] words = { "mass", "as", "hero", "superhero" };
        System.out.println(stringMatching(words));
    }
}
