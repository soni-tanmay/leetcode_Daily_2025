public class Solution {
    public static int minimumLength(String s) {
        for (byte c : s.getBytes()) {
            System.out.println(c);
        }
        int[] value = new int[26];
        for (char c : s.toCharArray()) {
            value[c - 'a']++;
            if (value[c - 'a'] >= 3) {
                value[c - 'a'] -= 2;
            }
        }
        int size = 0;
        for (int v : value) {
            size += v;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("aaaaaaa"));
    }
}
