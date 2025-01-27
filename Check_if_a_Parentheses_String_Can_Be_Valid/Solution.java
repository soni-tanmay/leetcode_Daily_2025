public class Solution {
    public static boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        int[] index = new int[s.length()];
        int zeroCount = 0;
        int openLocked = 0;

        for (int i = 0; i < s.length(); i++) {
            index[i] = locked.charAt(i) == '0' ? 0 : s.charAt(i) == ')' ? -1 : 1;
            if (index[i] == 0) {
                zeroCount++;
            } else if (index[i] == 1) {
                openLocked++;
            } else {
                if (openLocked > 0) {
                    openLocked--;
                } else if (zeroCount > 0) {
                    zeroCount--;
                } else {
                    return false;
                }
            }
        }
        zeroCount = 0;
        int closeLocked = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            index[i] = locked.charAt(i) == '0' ? 0 : s.charAt(i) == ')' ? -1 : 1;
            if (index[i] == 0) {
                zeroCount++;
            } else if (index[i] == -1) {
                closeLocked++;
            } else {
                if (closeLocked > 0) {
                    closeLocked--;
                } else if (zeroCount > 0) {
                    zeroCount--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeValid("))()))", "010100"));
    }
}
// Optimized
// int n = s.length();
// if (n % 2 != 0) {
// return false;
// }
// int upper = 0;
// int lower = 0;
// for (int i = 0; i < n; i++) {
// if (locked.charAt(i) == '1') {
// if (s.charAt(i) == '(') {
// lower++;
// upper++;
// } else {
// lower--;
// upper--;
// }
// } else {
// upper++;
// lower--;
// }
// if (lower < 0) {
// lower += 2;
// }
// if (upper < 0) {
// return false;
// }
// }
// return lower == 0;