package summary.twostar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【流水线】
 * 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？
 * 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 * 输入描述：
 * 第一行为2个整数（采用空格分隔），分别表示流水线个数m和作业数n；
 * 第二行输入n个整数（采用空格分隔），表示每个作业的处理时长t1,t2…tn。
 * 0< m,n<100，0<t1,t2…tn<100。
 * 注：保证输入都是合法的。
 * 输出描述：
 * 输出处理完所有作业的总时长
 * 示例1：
 * 输入
 * 3 5
 * 8 4 3 2 10
 * 输出
 * 13
 */
public class 流水线 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String[] array1 = s1.split(" ");
            String[] array2 = s2.split(" ");
            int m = Integer.parseInt(array1[0]);
            int n = Integer.parseInt(array1[1]);
            int[] nArray = new int[n];
            for (int j = 0; j < n; j++) {
                nArray[j] = Integer.parseInt(array2[j]);
            }
            Arrays.sort(nArray);
            if (n < m) {
                System.out.println(nArray[n - 1]);
            } else {
                int[] mArray = new int[m];
                for (int i = 0; i < n; i++) {
                    mArray[i % m] += nArray[i];
                }
                Arrays.sort(mArray);
                System.out.println(mArray[m - 1]);
            }
        }
    }
}
