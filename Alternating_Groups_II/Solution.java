class Solution {

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int length = colors.length;
        int result = 0;
        // Length of current alternating sequence
        int alternatingElementsCount = 1;
        int lastColor = colors[0];

        // Loop through array with circular traversal
        for (int i = 1; i < length + k - 1; i++) {
            int index = i % length; // Wrap around using modulo

            // Check if current color is the same as last color
            if (colors[index] == lastColor) {
                // Pattern breaks, reset sequence length
                alternatingElementsCount = 1;
                lastColor = colors[index];
                continue;
            }

            // Extend alternating sequence
            alternatingElementsCount += 1;

            // If sequence length reaches at least k, count it
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[] { 0, 1, 0, 1, 0 }, 3));
    }
}

// public class Solution {
// public int numberOfAlternatingGroups(int[] colors, int k) {
// int[] extendedColors = new int[colors.length + k - 1];
// // Extend the array to handle circular sequences
// for (int i = 0; i < colors.length; i++) {
// extendedColors[i] = colors[i];
// }
// for (int i = 0; i < k - 1; i++) {
// extendedColors[colors.length + i] = colors[i];
// }

// int length = extendedColors.length;
// int result = 0;
// // Initialize the bounds of the sliding window
// int left = 0;
// int right = 1;

// while (right < length) {
// // Check if the current color is the same as the last one
// if (extendedColors[right] == extendedColors[right - 1]) {
// // Pattern breaks, reset window from the current position
// left = right;
// right++;
// continue;
// }

// // Expand the window to the right
// right++;

// // Skip counting sequence if its length is less than k
// if (right - left < k) continue;

// // Record a valid sequence and shrink window from the left to search for more
// result++;
// left++;
// }

// return result;
// }
// }