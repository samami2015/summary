package summary.onestar;

import java.util.Scanner;

/**
 * 【求解连续数列】
 * 已知连续正整数数列{K}=K1,K2,K3...Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
 * <p>
 * 输入描述：
 * 输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。
 * 输出描述：
 * 如果有解输出数列K，如果无解输出-1
 * 备注：
 * 示例1：
 * 输入
 * 525 6
 * 输出
 * 85 86 87 88 89 90
 */
public class 求解连续数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int s = sc.nextInt();
            int n = sc.nextInt();

            int sum = 0;
            for (int i = 1; i < 100000; i++) {
                sum = (2 * i + n - 1) * n / 2;
                if (sum == s) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(i++);
                        if (j < n - 1) {
                            System.out.print(" ");
                        }
                    }
                    break;
                } else if (sum > s) {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
