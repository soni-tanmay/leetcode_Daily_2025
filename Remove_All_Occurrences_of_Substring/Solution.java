// source: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/?envType=daily-question&envId=2025-02-11

class Solution {
    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }
}

// Optimized
// class Solution {
// public static String removeOccurrences(String str, String part) {
// char[] input = str.toCharArray();
// char[] target = part.toCharArray();
// char[] resultStack = new char[input.length];
// int targetLength = target.length;
// int stackSize = 0;
// char targetEndChar = target[targetLength - 1];

// for (char currentChar : input) {
// resultStack[stackSize++] = currentChar;

// if (currentChar == targetEndChar && stackSize >= targetLength) {
// int i = stackSize - 1, j = targetLength - 1;

// while (j >= 0 && resultStack[i] == target[j]) {
// i--;
// j--;
// }

// if (j < 0) {
// stackSize = i + 1;
// }
// }
// }

// return new String(resultStack, 0, stackSize);
// }
// }