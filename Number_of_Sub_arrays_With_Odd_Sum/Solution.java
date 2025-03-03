public class Solution {
    public static int numOfSubarrays(int[] arr) {
        int odd = 0;
        int sum = 0;
        for (int i : arr) {
            odd += ((sum ^= i) & 1);
            System.out.println("odd: " + odd);
            System.out.println("Sum: " + sum);
        }
        return (int) ((odd + ((arr.length - odd) * (long) odd)) % 1_000_000_007);
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[] { 1, 3, 5 }));
    }
}