package od.leetcode;

public class LC0053 {
    public static void main(String[] args) {
        LC0053 solution = new LC0053();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = solution.maxSubArray(nums);
        System.out.println(ans);
    }
    public int maxSubArray(int[] nums) {
        int len = nums.length, max, dp;
        if (len == 0) return 0;
        // 要尽量大，就尽量不要负数
        dp = max = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp > 0) dp += nums[i];// 之前的和 > 0，那就累计进来
            else dp = nums[i];// 之前的和 <= 0，那就重新开始
            if (dp > max) max = dp; // max = Math.max(max, geektime.dp);
        }
        return max;
    }
}
