package summary.onestar;

import java.util.Scanner;

/**
 * 【用连续自然数之和来表达整数】
 * 一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。
 * 输入描述：
 * 一个目标整数T (1 <=T<= 1000)
 * 输出描述：
 * 该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为：
 * 1.自然数个数最少的表达式优先输出
 * 2.每个表达式中按自然数递增的顺序输出，具体的格式参见样例。在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
 * 示例1：
 * 输入
 * 9
 * 输出
 * 9=9
 * 9=4+5
 * 9=2+3+4
 * Result:3
 */
public class 用连续自然数之和来表达整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            StringBuilder result = new StringBuilder();
            for (int i = num; i > 0; i--) {
                int sum = 0;
                for (int j = i; j > 0; j--) {
                    sum += j;
                    if (sum == num) {
                        count++;
                        result.append(num).append("=");
                        for (int k = j; k <= i; k++) {
                            result.append(k).append("+");
                        }
                        result.setCharAt(result.length() - 1, '\n');
                    }else if(sum>num){
                        break;
                    }
                }
            }
            result.append("Result:").append(count);
            System.out.println(result.toString());
        }
    }
}
