import java.util.HashMap;

class Solution {

    public static String getHappyString(int n, int k) {
        int l = (int) (Math.pow(2, (n - 1)) * 3);
        if (k > l)
            return "";

        StringBuilder r = new StringBuilder();

        char[] c = new char[] { 'a', 'b', 'c' };
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('a', new char[] { 'b', 'c' });
        map.put('b', new char[] { 'a', 'c' });
        map.put('c', new char[] { 'a', 'b' });
        int m = l / 3;
        r.append(c[Math.ceilDiv(k, m) - 1]);
        while (m > 1) {
            if (k % m == 0) {
                k = m;
            } else {
                k = k % m;
            }
            l = m;
            m = l / 2;
            r.append(map.get(r.charAt(r.length() - 1))[Math.ceilDiv(k, m) - 1]);
        }

        return r.toString();
    }

    public static void main(String[] args) {
        System.out.println(getHappyString(5, 40));
    }
}
