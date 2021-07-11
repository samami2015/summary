package od.week01.twostar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 【二叉树的广度优先遍历】
 * 有一棵二叉树，每个节点由一个大写字母标识(最多26个节点）。现有两组字母，分别表示后序遍历（左孩子->右孩子->父节点）和中序
 * 遍历（左孩子->父节点->右孩子）的结果，请输出层次遍历的结果。
 * <p>
 * 输入描述：
 * 输入为两个字符串，分别是二叉树的后续遍历和中序遍历结果。
 * 输出描述：
 * 输出二叉树的层次遍历结果。
 * 示例1：
 * 输入
 * CBEFDA CBAEDF
 * 输出
 * ABDCEF
 */

public class 二叉树的广度优先遍历 {
    static class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        TreeNode(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] words = line.split(" ");
        String s1 = words[0], s2 = words[words.length - 1];
        TreeNode root = getRoot(s1, s2);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(String.valueOf(node.value));
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private static TreeNode getRoot(String s1, String s2) {
        char nodeValue = s1.charAt(s1.length() - 1);
        TreeNode node = new TreeNode(nodeValue);
        int middleTraversalIndex = s2.indexOf(nodeValue);
        if (middleTraversalIndex > 0) {
            node.left = getRoot(s1.substring(0, middleTraversalIndex), s2.substring(0, middleTraversalIndex));
        }
        if (middleTraversalIndex < s2.length() - 1) {
            node.right = getRoot(s1.substring(middleTraversalIndex, s1.length() - 1), s2.substring(middleTraversalIndex + 1));
        }
        return node;
    }
}
