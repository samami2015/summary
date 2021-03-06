package summary.twostar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【检查是否存在满足条件的数字组合】
 * 给定一个正整数数组，检查数组中是否存在满足规则的数字组合
 * 规则：
 * A = B + 2C
 * 输入描述：
 * 第一行输出数组的元素个数。
 * 接下来一行输出所有数组元素，用空格隔开。
 * 输出描述：
 * 如果存在满足要求的数，在同一行里依次输出规则里A/B/C的取值，用空格隔开。
 * 如果不存在，输出0。
 * 备注：
 * 1. 数组长度在3-100之间。
 * 2. 数组成员为0-65535，数组成员可以重复，但每个成员只能在结果算式中使用一次。如：数组成员为[0, 0, 1, 5]，0出现2次是允许的，但结果0 = 0 + 2 * 0是不允
 * 许的，因为算式中使用了3个0。
 * 3. 用例保证每组数字里最多只有一组符合要求的解。
 * 示例1：
 * 输入
 * 4
 * 2 7 3 0
 * 输出
 * 7 3 2
 */
public class 检查是否存在满足条件的数字组合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(getf(a));
    }

    private static String getf(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = i - 1; k >= 0; k--) {
                    if (j != k && a[i] == a[j] + 2 * a[k]) {
                        return a[i] + " " + a[j] + " " + a[k];
                    }
                }
            }
        }
        return "0";
    }
}
