class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;// 4,3,2,1
        int[] differenceArray = new int[n + 1];// 1,2,0,-1,-2

        // Iterate through nums
        for (int index = 0; index < n; index++) {
            // Iterate through queries while current index of nums cannot equal zero
            while (sum + differenceArray[index] < nums[index]) {
                k++;// 3

                // Zero array isn't formed after all queries are processed
                if (k > queries.length) {
                    return -1;
                }
                int left = queries[k - 1][0], right = queries[k - 1][1], val = queries[k - 1][2];

                // Process start and end of range
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            // Update prefix sum at current index
            sum += differenceArray[index];// 0
        }
        return k;
    }
}