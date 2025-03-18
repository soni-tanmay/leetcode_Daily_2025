import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}

// Optimized
// class Solution {

// public boolean divideArray(int[] nums) {
// // Track unpaired numbers
// Set<Integer> unpaired = new HashSet<>();

// // Add numbers to set if unseen, remove if seen
// for (int num : nums) {
// if (unpaired.contains(num)) {
// unpaired.remove(num);
// } else {
// unpaired.add(num);
// }
// }

// // Return true if all numbers were paired
// return unpaired.isEmpty();
// }
// }