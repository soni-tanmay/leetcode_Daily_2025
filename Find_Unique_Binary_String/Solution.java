class Solution {

    public static String findDifferentBinaryString(String[] nums) {
        int l = nums[0].length();
        double d = Math.pow(2, l);
        int n = (int) d;
        int[] a = new int[n];
        String result = "";
        for (String num : nums) {
            a[Integer.parseInt(num, 2)] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                result = Integer.toBinaryString(i);
                break;
            }
        }

        for (int m = result.length(); m < l; m++) {
            result = "0" + result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[] { "01", "10" }));
    }
}
