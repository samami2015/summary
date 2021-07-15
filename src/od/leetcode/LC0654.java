package od.leetcode;

public class LC0654 {
    public static void main(String[] args) {
        LC0654 solution = new LC0654();
        int[] nums = {3,2,1,6,0,5};
        TreeNode ans = solution.constructMaximumBinaryTree(nums);
        System.out.println(ans.val);
    }

    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    //将 nums[lo..hi] 构造成符合条件的树，返回根节点
    TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 递归调用构造左右子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}

