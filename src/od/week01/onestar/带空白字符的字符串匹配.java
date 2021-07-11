package od.week01.onestar;

import java.util.Scanner;

/**
 * 【带空白字符的字符串匹配】
 * 给定两行均不为空的字符串，第一行字符串中包含了一些空白（空格、tab），第二行字符串不包含任何空白。查找第二行字符串在第
 * 一行字符串中出现的次数（匹配时忽略空白，大小写字母是不同的字符）。
 * <p>
 * 输入描述：
 * 1:长度小于等于1024的带空白字符的字符串。
 * 2:长度小于等于1024的不带空白字符的字符串。
 * <p>
 * 输出描述：
 * 输出匹配到的次数。
 * <p>
 * 示例1：
 * 输入
 * Abb bca acb bd
 * bb
 * 输出
 * 3
 */
public class 带空白字符的字符串匹配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        s1 = s1.replaceAll("\\s*", "");
        String s2 = in.nextLine();
        s2 = s2.replace(" ", "");
        int count = 0;
        for (int i = 0; i < s1.length() - s2.length() + 1; i += 1) {
            String partS1 = s1.substring(i, i + s2.length());
            if (partS1.equals(s2)) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
