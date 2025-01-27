public class Solution {
    public static int minimizeXor(int num1, int num2) {
        int result = num1;
        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = Integer.bitCount(result);

        if (setBitsCount != targetSetBitsCount) {
            int currentBit = 0;
            while (setBitsCount < targetSetBitsCount) {
                if ((result & (1 << currentBit)) == 0) {
                    result |= (1 << currentBit);
                    setBitsCount++;
                }
                currentBit++;
            }
            while (setBitsCount > targetSetBitsCount) {
                if ((result & (1 << currentBit)) != 0) {
                    result &= ~(1 << currentBit);
                    setBitsCount--;
                }
                currentBit++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimizeXor(1, 12));
    }
}
