package summary.week.onestar;

import java.util.Scanner;

/**
 * 【寻找相同子串】
 * 给你两个字符串 t 和 p ，要求从 t 中找到一个和 p 相同的连续子串，并输出该字串第一个字符的下标。
 * <p>
 * 输入描述：
 * 输入文件包括两行，分别表示字符串 t 和 p ，保证 t 的长度不小于 p ，且 t 的长度不超过1000000，p 的长度不超过10000。
 * <p>
 * 输出描述：
 * 如果能从 t 中找到一个和 p 相等的连续子串，则输出该子串第一个字符在t中的下标（下标从左到右依次为1,2,3,…）；如果不能则输出”No”；如果含有多个这样的
 * 子串，则输出第一个字符下标最小的。
 * <p>
 * 示例1：
 * 输入
 * AVERDXIVYERDIAN
 * RDXI
 * 输出
 * 4
 */
public class 寻找相同子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        int result = findSubStr(first, second);
        if(result==-1) System.out.println("No");
        else System.out.println(result);
    }

    private static int findSubStr(String first, String second) {
        int subStrlen = second.length();
        for (int i = 0; i < first.length() - subStrlen + 1; i++) {
            if (first.substring(i, i + subStrlen).equals(second)) return i + 1;
        }
        return -1;
    }
}
