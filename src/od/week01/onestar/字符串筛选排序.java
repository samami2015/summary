package od.week01.onestar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【字符串筛选排序】
 * 输入一个由n个大小写字母组成的字符串，按照Ascii码值从小到大的排序规则，查找字符串中第k个最小ascii码值的字母（k>=1），输出该字母
 * 所在字符串的位置索引(字符串的第一个字符位置索引为0）。
 * k如果大于字符串长度，则输出最大ascii值的字母所在字符串的位置索引，如果有重复的字母，则输出字母的最小位置索引。
 * <p>
 * 输入描述：
 * 第一行输入一个由大小写字母组成的字符串
 * 第二行输入k，k必须大于0，k可以大于输入字符串的长度
 * <p>
 * 输出描述：
 * 输出字符串中第k个最小ascii码值的字母所在字符串的位置索引。k如果大于字符串长度，则输出最大ascii值的字母所在字符串的位置索引，如果第k个最小ascii码
 * 值的字母存在重复，则输出该字母的最小位置索引。
 * <p>
 * 示例1：
 * 输入
 * AbCdeFG
 * 3
 * 输出
 * 5
 */
public class 字符串筛选排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int k = in.nextInt();
        if (k > line.length()) {
            k = line.length();
        }
        char[] chars = line.toCharArray();
        char[] copy = Arrays.copyOf(chars, chars.length);

        Arrays.sort(copy);
        char c = copy[k - 1];

        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
