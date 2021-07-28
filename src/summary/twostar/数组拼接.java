package summary.twostar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 【数组拼接】
 * 现在有多组整数数组，需要将它们合并成一个新的数组。合并规则，从每个数组里按顺序取出固定长度的内容合并到新的数组中，取完的内容会删除掉，如果该行不
 * 足固定长度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
 * 输入描述：
 * <p>
 * 第一行是每次读取的固定长度，0<长度<10
 * 第二行是整数数组的数目，0<数目<1000
 * 第3-n行是需要合并的数组，不同的数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素。
 * <p>
 * 输出描述：
 * 输出一个新的数组，用逗号分隔。
 * 示例1：
 * 输入
 * 3
 * 2
 * 2,5,6,7,9,5,7
 * 1,7,4,3,4
 * 输出
 * 2,5,6,1,7,4,7,9,5,3,4,7
 */
public class 数组拼接 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int m = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> sc = new ArrayList<>();
        int k = 0;
        while (k < m) {
            sc.add(scanner.nextLine());
            k++;
        }
        vers(n, m, sc);
    }

    private static void vers(int n, int m, ArrayList<String> sc) {
        String back = "";
        while (!empty(sc)) {
//        while (!sc.isEmpty()) {
            for (int i = 0; i < sc.size(); i++) {
                String stringTemp = sc.get(i);
                if (stringTemp == null) {
                    continue;
                }
                String[] arrayTemp1 = stringTemp.split(",");
                if (stringTemp.length() == 0) {
                    sc.set(i, null);
                } else {
                    if (arrayTemp1.length <= n) {
                        back = back + stringTemp + ",";
                        sc.set(i, null);
                    } else {
                        for (int k = 0; k < n; k++) {
                            back = back + arrayTemp1[k] + ",";
                        }
                        String arrayTemp2 = "";
                        for (int l = n; l < arrayTemp1.length; l++) {
                            if (l == arrayTemp1.length - 1) {
                                arrayTemp2 = arrayTemp2 + arrayTemp1[l];
                            } else {
                                arrayTemp2 = arrayTemp2 + arrayTemp1[l] + ",";
                            }
                        }
                        sc.set(i, arrayTemp2);
                    }
                }
            }
        }
        System.out.println(back.substring(0, back.length() - 1));
    }

    private static boolean empty(ArrayList<String> sc) {
        int i;
        for (i = 0; i < sc.size(); i++) {
            if (sc.get(i) != null) {
                break;
            }
        }
        if (i < sc.size()) {
            return false;
        } else {
            return true;
        }
    }
}
