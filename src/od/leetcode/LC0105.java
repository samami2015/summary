package od.leetcode;

public class LC0105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        LC0105 solution = new LC0105();
        TreeNode ans = solution.buildTree(preorder, inorder);
        System.out.println(ans.val);
    }

    /* 主函数 */
    TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /*
      若前序遍历数组为 preorder[preStart..preEnd]，
      后续遍历数组为 inorder[inStart..inEnd]，
      构造二叉树，返回该二叉树的根节点
   */
    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftsize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftsize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftsize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
