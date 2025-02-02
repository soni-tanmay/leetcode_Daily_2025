import java.util.Arrays;

public class Solution {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        int[] rotated = new int[n];
        int x = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                x = i + 1;
                break;
            }
        }

        if (x != -1) {
            for (int i = 0; i < n; i++) {
                rotated[i] = nums[(i + x) % n];
                sorted[i] = nums[i];
            }
            Arrays.sort(sorted);

            for (int i = 0; i < n; i++) {
                if (rotated[i] != sorted[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 4, 5, 1, 2 };
        System.out.println(check(nums));
    }
}

// Optimized
// class Solution {
// public boolean check(int[] arr) {
// int count=0;
// for(int i=1;i<arr.length;i++){
// if(arr[i]<arr[i-1]){
// count++;
// }
// }
// if(arr[arr.length-1]>arr[0]){
// count++;
// }
// return count<=1;
// }
// }