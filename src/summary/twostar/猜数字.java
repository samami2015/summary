package summary.twostar;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 【猜数字】
 * 一个人设定一组四码的数字作为谜底，另一方猜。每猜一个数，出数者就要根据这个数字给出提示，提示以XAYB形式呈现，直到猜中为止。其中X表示
 * 位置正确的数的个数（数字正确且位置正确），而Y表示数字正确而位置不对的数的个数。
 * 例如，当谜底为8123，而猜谜者猜1052时，出题者必须提示0A2B。
 * 例如，当谜底为5637，而猜谜者猜4931时，出题者必须提示1A0B。
 * 当前已知N组猜谜者猜的数字与提示，如果答案确定，请输出答案，不确定则输出NA。
 * <p>
 * 输入描述：
 * 第一行输入一个正整数N，0<N<100。
 * 接下来N行，每一行包含一个猜测的数字与提示结果。
 * 输出描述：
 * 输出最后的答案，答案不确定则输出NA。
 * 示例1：
 * 输入
 * 6
 * 4815 1A1B
 * 5716 0A1B
 * 7842 0A1B
 * 4901 0A0B
 * 8585 3A0B
 * 8555 2A1B
 * 输出
 * 3585
 */

public class 猜数字 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String[] numbers = new String[n];
            String[] results = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = in.next();
                results[i] = in.next();
            }
            String[] candidates = new String[10000];
            for (int i = 0; i < 10000; i++) {
                StringBuilder stringBuilder = new StringBuilder(Integer.toString(i));
                int len = stringBuilder.length();
                //System.out.println(len);
                for (int j = 0; j < 4 - len; j++) {
                    stringBuilder.insert(0, '0');
                }
                candidates[i] = stringBuilder.toString();
            }
            List avi = new LinkedList<>();
            for (int i = 0; i < 10000; i++) {
                int j = 0;
                for (j = 0; j < n; j++) {
                    if (!telldiff(candidates[i], numbers[j]).equals(results[j])) {
                        break;
                    }
                }
                if (j == n) avi.add(candidates[i]);
            }
            if (avi.size() == 1) {
                System.out.println(avi.get(0));
            } else {
                System.out.println("NA");
            }
        }
    }

    private static String telldiff(String candidate, String guess) {
        int a = 0;
        int[] ta = new int[10];
        int[] tb = new int[10];
        boolean[] tc = new boolean[10];
        for (int i = 0; i < 4; i++) {
            if (candidate.charAt(i) == guess.charAt(i)) {
                a++;
                tc[candidate.charAt(i) - '0'] = true;
            }
            ta[candidate.charAt(i) - '0']++;
            tb[guess.charAt(i) - '0']++;
        }
        int b = 0;
        for (int i = 0; i < 10; i++) {
            if (ta[i] > 0 && tb[i] > 0 && !tc[i]) {
                b += tb[i];
            }
        }
        return a + "A" + b + "B";
    }
}
