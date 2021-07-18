package summary.twostar;

import java.util.*;

/**
 * 【幻方修复2】
 * 幻方（Magic Square）是一个由1~N 共N 个整数构成的N*N矩阵，满足每行、列和对角线上的数字和都相等。
 * 上回你已经帮助小明将写错一个数字的幻方进行了修复，小明在感谢之余也想进一步试试你的水平，于是他准备了有两个数字发生了位置交换的幻方。
 * 你可以把这两个交换的数字找出来并且改正吗？
 * <p>
 * 输入描述：
 * 第一行输入一个整数N，代表待检验幻方的阶数（3 ≤ N < 50）
 * 接下来的N行，每行N个整数，空格隔开（1 ≤ 每个整数 ≤ N2）
 * <p>
 * 输出描述：
 * 输出两行，代表两条纠正信息。注意先输出行号小的，若行号相同则先输出列号小的
 * 每行输出空格隔开的三个整数，分别是：出错行号、出错列号、应填入的数字（末尾无空格）
 * <p>
 * 示例1：
 * 输入
 * 3
 * 8 1 9
 * 3 5 7
 * 4 6 2
 * 输出
 * 1 3 6
 * 3 2 9
 */
public class 幻方修复2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int sum = (1 + n * n) * n / 2;
        int[][] ms = new int[n][n];
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        List<Integer> rowErrorList = new ArrayList<>();
        List<Integer> colErrorList = new ArrayList<>();

        Map<Integer, List<Integer>> rowSumCountMap = new HashMap<>();
        Map<Integer, List<Integer>> colSumCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] ss = str.split(" ");
            for (int j = 0; j < n; j++) {
                ms[i][j] = Integer.parseInt(ss[j]);
                rowSum[i] += ms[i][j];
                colSum[j] += ms[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (rowSum[i] != sum) {
                rowErrorList.add(i);
            }
            if (colSum[i] != sum) {
                colErrorList.add(i);
            }
        }

        if (colErrorList.size() == 2 && rowErrorList.size() == 0) {
            int colError1 = colErrorList.get(0);
            int colError2 = colErrorList.get(1);
            for (int i = 0; i < n; i++) {
                if (colSum[colError1] - ms[i][colError1] + ms[i][colError2] == sum) {
                    System.out.println((i + 1) + " " + (colError1 + 1) + " " + ms[i][colError2]);
                    System.out.println((i + 1) + " " + (colError2 + 1) + " " + ms[i][colError1]);
                    return;
                }
            }
        }
        if (colErrorList.size() == 0 && rowErrorList.size() == 2) {
            int rowError1 = rowErrorList.get(0);
            int rowError2 = rowErrorList.get(1);
            for (int i = 0; i < n; i++) {
                if (rowSum[rowError1] - ms[rowError1][i] + ms[rowError2][i] == sum) {
                    System.out.println((rowError1 + 1) + " " + (i + 1) + " " + ms[rowError2][i]);
                    System.out.println((rowError2 + 1) + " " + (i + 1) + " " + ms[rowError1][i]);
                    return;
                }
            }
        }

        if (colErrorList.size() == 2 && rowErrorList.size() == 2) {
            int rowError1 = rowErrorList.get(0);
            int rowError2 = rowErrorList.get(1);
            int colError1 = colErrorList.get(0);
            int colError2 = colErrorList.get(1);

            if (rowSum[rowError1] - ms[rowError1][rowError2] + ms[rowError2][colError2] == sum) {
                System.out.println((rowError1 + 1) + " " + (colError1 + 1) + " " + ms[rowError2][colError2]);
                System.out.println((rowError2 + 1) + " " + (colError2 + 1) + " " + ms[rowError1][colError1]);
            } else {
                System.out.println((rowError1 + 1) + " " + (colError2 + 1) + " " + ms[rowError2][colError1]);
                System.out.println((rowError2 + 1) + " " + (colError1 + 1) + " " + ms[rowError1][colError2]);
            }
        }
    }
}
