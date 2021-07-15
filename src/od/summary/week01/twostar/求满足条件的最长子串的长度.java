package od.summary.week01.twostar;

import java.util.Scanner;

/**
 * 【求满足条件的最长子串的长度】
 * 给定一个字符串，只包含字母和数字，按要求找出字符串中的最长（连续）子串的长度，字符串本身是其最长的子串，子串要求：
 * 1、 只包含1个字母(a~z, A~Z)，其余必须是数字；
 * 2、 字母可以在子串中的任意位置；
 * 如果找不到满足要求的子串，如全是字母或全是数字，则返回-1。
 * <p>
 * 输入描述：
 * 字符串(只包含字母和数字)
 * 输出描述：
 * 子串的长度
 * 示例1：
 * 输入
 * abC124ACb
 * 输出
 * 4
 */
public class 求满足条件的最长子串的长度 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String inStr = sc.nextLine();
            char[] charArray = inStr.toCharArray();
            boolean flag0 = false;
            boolean flag1 = false;
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] >= 65) {
                    charArray[i] = '1';
                    flag0 = true;
                } else {
                    charArray[i] = '0';
                    flag1 = true;
                }
            }
            if (flag0 && flag1) {
                int maxSubLength = 0;
                boolean flagChange = false;
                char before = '0';
                int subLength = 0;
                int subSubLength = 0;
                int start = 0;
                while (charArray[start] == '1') {
                    start++;
                }
                for (int i = start; i < charArray.length; i++) {
                    if (!flagChange && before == charArray[i]) {
                        subLength++;
                    } else if (!flagChange && before != charArray[i]) {
                        flagChange = true;
                        subLength++;
                    } else if (flagChange && before == charArray[i]) {
                        subLength++;
                        subSubLength++;
                    } else {
                        if (charArray[i - 1] == charArray[i]) {
                            subLength=0;
                            subSubLength=0;
                            flagChange = false;
                        } else {
                            subLength = subSubLength + 1;
                            subSubLength = 0;
                        }
                    }
                    if (maxSubLength < subLength) {
                        maxSubLength = subLength;
                    }
                }
                if (maxSubLength == subLength && !flagChange) {
                    maxSubLength++;
                }
                System.out.println(maxSubLength);
            } else {
                System.out.println(-1);
            }
        }
    }
}


