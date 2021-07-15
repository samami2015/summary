package od.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    Map<Integer, Integer> freq = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {

    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int other = value - key;
            if (other == key && freq.get(key) > 1) return true;
            if (other != key && freq.containsKey(other)) return true;
        }
        return false;
    }
}
