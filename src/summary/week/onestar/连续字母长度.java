package summary.week.onestar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【连续字母长度】
 * 给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第 k 长的子串的长度，相同字母只取最长的那个子串。
 * 输入描述：
 * 第一行有一个子串(1<长度<=100)，只包含大写字母。
 * 第二行为 k的值
 * 输出描述：
 * 输出连续出现次数第k多的字母的次数。
 * 备注：
 * 若子串中只包含同一字母的子串数小于k，则输出-1
 * 示例1：
 * 输入
 * AAAAHHHBBCDHHHH
 * 3
 * 输出
 * 2
 */
public class 连续字母长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        int[] nums = new int[26];
        char cu = s.charAt(0);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == cu) {
                count++;
            } else {
                if (count > nums[cu - 'A']) {
                    nums[cu - 'A'] = count;
                }
                count = 1;
                cu = c;
            }
        }
        if (count > nums[cu - 'A']) {
            nums[cu - 'A'] = count;
        }
        ArrayList<Integer> out = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            if (nums[i] > 0) {
                out.add(nums[i]);
            }
        }
        out.sort((a, b) -> {
            return b - a;
        });
        if (k < 1 || k > out.size()) {
            System.out.println(-1);
        } else {
            System.out.println(out.get(k - 1));
        }
    }
}
