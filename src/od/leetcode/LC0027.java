package od.leetcode;

public class LC0027 {
    public static void main(String[] args) {
        LC0027 solution = new LC0027();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int ans = solution.removeElement(nums, val);
        System.out.println(ans);
    }

    //nums = [3,2,2,3], val = 3
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //找寻到与val不同的值的时候，就将其存入数组前部
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
