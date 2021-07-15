package od.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC0001 {
    public static void main(String[] args) {
        LC0001 solution = new LC0001();
        int[] nums = {3, 1, 3, 6};
        int target = 6;
        int[] ans = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    /*    public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{-1, -1};
        }*/
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }
        }
        return new int[]{-1, -1};
    }

}
