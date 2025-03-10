
public class Solution {
    public static int minimumRecolors(String blocks, int k) {
        char[] array = blocks.toCharArray();
        int minCount = 0;
        int count = 0;
        int i = 0;
        while (i < k) {
            if (array[i] == 'W') {
                count++;
            }
            i++;
        }
        minCount = count;
        while (i < array.length) {
            if (array[i] == 'W') {
                count++;
            }
            if (array[i - k] == 'W') {
                count--;
            }
            if (minCount > count) {
                minCount = count;
            }
            i++;
        }

        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBB", 1));
    }
}
