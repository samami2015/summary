package od.summary.week01.onestar;

import java.util.Scanner;

/**
 * 【来自异国的客人】
 * 有位客人来自异国，在该国使用m进制计数。该客人有个幸运数字n(n<m)，每次购物时，其总是喜欢计算本次支付的花费(折算为异国的价格后)
 * 中存在多少幸运数字。问：当其购买一个在我国价值k的产品时，其中包含多少幸运数字？
 * <p>
 * 输入描述：
 * 第一行输入为 k, n, m。
 * 其中：
 * k 表示 该客人购买的物品价值（以十进制计算的价格）
 * n 表示 该客人的幸运数字
 * m 表示 该客人所在国度的采用的进制
 * <p>
 * 输出描述：
 * 输出幸运数字的个数，行末无空格。
 * <p>
 * 备注：
 * 当输入非法内容时，输出0
 * <p>
 * 示例1：
 * 输入
 * 10 2 4
 * 输出
 * 2
 */
public class 来自异国的客人 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long k = scanner.nextLong();
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            long count = 0;
            while (k != 0) {
                long t = k / m;
                long l = k % m;
                if (l == n) {
                    count++;
                }
                k = t;
            }
            System.out.println(count);
        }
    }
}
