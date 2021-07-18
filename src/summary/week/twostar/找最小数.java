package summary.week.twostar;

import java.util.Scanner;

/**
 * 【找最小数】
 * 给一个正整数NUM1，计算出新正整数NUM2，NUM2为NUM1中移除N位数字后的结果，需要使得NUM2的值最小。
 * 输入描述：
 * 1.输入的第一行为一个字符串，字符串由0-9字符组成，记录正整数NUM1，NUM1长度小于32。
 * 2.输入的第二行为需要移除的数字的个数，小于NUM1长度。
 * 如：
 * 2615371
 * 4
 * <p>
 * 输出描述：
 * 输出一个数字字符串，记录最小值NUM2。
 * 如：131
 * <p>
 * 示例1：
 * 输入
 * 2615371
 * 4
 * 输出
 * 131
 */
public class 找最小数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();
        int len = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }
        int flag = 0;
        while (flag < len && stack[flag] == '0') {
            flag++;
        }
        if (flag == len) {
            System.out.println('0');
        } else {
            System.out.println(new String(stack, flag, len - flag));
        }
    }
}
