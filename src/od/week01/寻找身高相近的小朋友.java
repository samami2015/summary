package od.week01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 【寻找身高相近的小朋友】
 * 小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差对他们进行排序，请
 * 帮他实现排序。
 * <p>
 * 输入描述：
 * 第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。
 * 第二行为N个正整数H1-HN，分别是其他小朋友的身高，取值范围0<Hi<200（1<=i<=N），且N个正整数各不相同。
 * 输出描述：
 * 输出排序结果，各正整数以空格分割。和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，如果两个小朋友和小明身高差一
 * 样，则个子较小的小朋友排在前面。
 * <p>
 * 示例1：
 * 输入
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 * 输出
 * 99 101 98 102 97 103 96 104 95 105
 */
public class 寻找身高相近的小朋友 {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                int v = Integer.parseInt(data[0]);
                int n = Integer.parseInt(data[1]);
                line = scanner.nextLine();
                data = line.split(" ");
                List<Data> list = new ArrayList<>();
                for (String s : data) {
                    int k = Integer.parseInt(s);
                    list.add(new Data(Math.abs(k - v), k));
                }
                Collections.sort(list);

                StringBuilder sb = new StringBuilder();
                for (Data d : list) {
                    sb.append(d.value).append(" ");
                }
                String str = sb.toString().trim();
                System.out.println(str);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    static class Data implements Comparable<Data> {
        public Data(int abs, int value) {
            this.abs = abs;
            this.value = value;
        }

        int abs = 0;
        int value = 0;

        @Override
        public int compareTo(Data o) {
            if (this.abs == o.abs) {
                return this.value - o.value;
            }
            return this.abs - o.abs;
        }
    }
}
