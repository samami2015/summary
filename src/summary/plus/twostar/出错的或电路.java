package summary.plus.twostar;

import java.util.Scanner;

/**
 * 【出错的或电路】
 * 某生产门电路的厂商发现某一批次的或门电路不稳定，具体现象为计算两个二进制数的或操作时，第一个二进制数中某两个比特位会出现交换，交
 * 换的比特位置是随机的，但只交换这两个位，其他位不变。很明显，这个交换可能会影响最终的或结果，也可能不会有影响。为了评估影响和定位出错的根因，工程
 * 师需要研究在各种交换的可能下，最终的或结果发生改变的情况有多少种。
 * 输入描述：
 * 第一行有一个正整数N，其中 。
 * 第二行有一个长为N的二进制数，表示与电路的第一个输入数，即会发生比特交换的输入数。
 * 第三行有一个长为N的二进制数，表示与电路的第二个输入数。注意第二个输入数不会发生比特交换。
 * 输出描述：
 * 输出只有一个整数，表示会影响或结果的交换方案个数。
 * 示例1：
 * 输入
 * 3
 * 010
 * 110
 * 输出
 * 1
 */
public class 出错的或电路 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.nextLine());
            String x = scanner.nextLine();
            String y = scanner.nextLine();

            int x0 = 0, x1 = 0, x0y0 = 0, x1y0 = 0;
            for (int i = 0; i < num; i++) {
                if (x.charAt(i) == 0) {
                    x0++;
                    if (y.charAt(i) == 0) {
                        x0y0++;
                    }
                } else {
                    x1++;
                    if (y.charAt(i) == 0) {
                        x1y0++;
                    }
                }
            }
            System.out.println(x0 * x1y0 + x1 * x0y0 - x0y0 * x1y0);
        }
    }
}
