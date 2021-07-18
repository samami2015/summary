package summary.week.onestar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 【数组二叉树】
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2*N
 * 和2*N+1，并且我们用值-1代表一个节点为空。
 * <p>
 * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 * 输入描述：
 * 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中
 * 没有使用，所以我们省略了。输入的树最多为7层。
 * <p>
 * 输出描述：
 * 输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。
 * <p>
 * 示例1：
 * 输入
 * 3 5 7 -1 -1 2 4
 * <p>
 * 输出
 * 3 7 2
 */
public class 数组二叉树 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (scanner.hasNextInt()) {
            line = scanner.nextLine();
            String[] items = line.split(" ");
            int size = items.length;
            int[] tree = new int[size + 1];
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = size; i >= 1; i--) {
                tree[i] = Integer.parseInt(items[i - 1]);
                if ((2 * i + 1) > size || (tree[2 * i] == -1 && tree[2 * i + 1] == -1)) {
                    if (tree[i] > 0 && tree[i] < min) {
                        min = tree[i];
                        minIndex = i;
                    }
                }
            }
            List<Integer> list = new ArrayList<>();
            while (true) {
                list.add(tree[minIndex]);
                minIndex = minIndex / 2;
                if (minIndex == 0) {
                    break;
                }
            }
            Collections.reverse(list);
            System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
