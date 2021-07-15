package od.leetcode;

public class LC0167 {
    public static void main(String[] args) {
        LC0167 solution = new LC0167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = solution.twoSum(numbers, target);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
