package od.week01.onestar;

import java.util.Scanner;

/**
 * 【回文素数】
 * 给定一个整数N，生成不大于N的所有回文素数，第一个数字是素数的个数，之后是生成的素数，素数按从小到大的顺序排列。如果没有生成任何素数，则输出0。
 * 如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数，例如101是回文数。
 * <p>
 * 输入描述：
 * 给定一个整数。
 * <p>
 * 输出描述：
 * 输出不大于该整数的所有素数。
 * <p>
 * 示例1：
 * 输入
 * 50
 * 输出
 * 5,2,3,5,7,11
 */
public class 回文素数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            StringBuffer sysString = new StringBuffer();
            if (num < 0) {
                System.out.println(0);
            } else if (num == 0) {
                System.out.println(0);
            } else if (num == 1) {
                System.out.println(0);
            } else if (num == 2) {
                System.out.println("1,2");
            } else {
                for (int i = 3; i <= num; i++) {
                    boolean flag = true;
                    int temp = (int) (Math.floor(Math.sqrt(i)) + 1);
                    for (int j = 2; j <= temp; j++) {
                        if (i % j == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(i);
                        StringBuffer renum = stringBuffer.reverse();
                        if (Integer.valueOf(renum.toString()) - i == 0) {
                            count++;
                            sysString.append(i + ",");
                        }
                    }
                }
                count++;
                String sys = count + ",2," + sysString.toString();
                System.out.println(sys.substring(0, sys.length() - 1));
            }
        }
    }
}
