package summary.twostar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 【最大值】
 * 给定一组整数（非负），重排顺序后输出一个最大的整数。
 * <p>
 * 示例 1:
 * 输入: [10,9]
 * 输出: 910
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 输入描述：
 * 数字组合
 * <p>
 * 输出描述：
 * 最大的整数
 * <p>
 * 示例1：
 * 输入
 * 10 9
 * 输出
 * 910
 */
public class 最大值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] numbers = in.nextLine().split(" ");
            Arrays.sort(numbers, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    Long num1 = Long.parseLong(o1 + o2);
                    Long num2 = Long.parseLong(o2 + o1);

                    return (num2).compareTo(num1);
                }
            });
            StringBuilder res = new StringBuilder();
            for (String number : numbers) {
                res.append(number);
            }
            boolean isZero = true;
            for (char c : res.toString().toCharArray()) {
                if (c != '0') isZero = false;
            }
            if (isZero) {
                System.out.println("0");
            } else {
                System.out.println(res.toString());
            }
        }
    }
}
