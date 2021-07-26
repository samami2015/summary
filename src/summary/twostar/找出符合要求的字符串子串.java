package summary.twostar;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 【找出符合要求的字符串子串】
 * 给定两个字符串，从字符串2中找出字符串1中的所有字符，去重并按照ASCII值从小到大排序
 * 输入字符串1：长度不超过1024
 * 输入字符串2：长度不超过1000000
 * 字符范围满足ASCII编码要求，按照ASCII的值由小到大排序
 * <p>
 * 输入描述：
 * bach
 * bbaaccedfg
 * <p>
 * 输出描述：
 * abc
 * <p>
 * 备注：
 * 输入字符串1 为给定字符串bach，输入字符串2 bbaaccedfg
 * 从字符串2中找出字符串1的字符，去除重复的字符，并且按照ASCII值从小到大排序，得到输出的结果为abc。
 * 字符串1中的字符h在字符串2中找不到不输出。
 * <p>
 * 示例1：
 * 输入
 * fach
 * bbaaccedfg
 * <p>
 * 输出
 * acf
 */
public class 找出符合要求的字符串子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String small = sc.nextLine();
            String big = sc.nextLine();
            TreeSet<Character> set = new TreeSet<>();
            char[] arr = small.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (big.contains(arr[i] + "")) {
                    set.add(arr[i]);
                }
            }
            for (Character c : set) {
                System.out.print(c);
            }
        }
    }
}
