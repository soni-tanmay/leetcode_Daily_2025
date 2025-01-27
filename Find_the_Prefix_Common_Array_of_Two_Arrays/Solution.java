import java.util.HashMap;

class Solution {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] C = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
                if (map.get(A[i]) == 0) {
                    count++;
                }
            }
            if (!map.containsKey(B[i])) {
                map.put(B[i], -1);
            } else {
                map.put(B[i], map.get(B[i]) - 1);
                if (map.get(B[i]) == 0) {
                    count++;
                }
            }
            C[i] = count;
        }
        return C;
        // Optimized
        // int n = A.length;
        // int[] result = new int[n];
        // int[] arr = new int[n + 1];
        // int max = 0;
        // for (int i = 0; i < n; i++) {
        // if (++arr[A[i]] == 2) max++;
        // if (++arr[B[i]] == 2) max++;
        // result[i] = max;
        // }
        // return result;
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 2, 4 }, B = { 3, 1, 2, 4 };
        int[] res = findThePrefixCommonArray(A, B);
    }
}