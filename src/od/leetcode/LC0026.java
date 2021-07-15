package od.leetcode;

public class LC0026 {
    public static void main(String[] args) {
        LC0026 solution = new LC0026();
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int ans = solution.removeDuplicates(nums);
        System.out.println(ans);
    }

    public int removeDuplicates(int[] nums) {
        int count = 0;
        //nums = [1,1,2] -> [1,2,2]
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}
