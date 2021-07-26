package summary.twostar;

import java.util.*;

/**
 * 【火锅】
 * 入职后，导师会请你吃饭，你选择了火锅。
 * 火锅里会在不同时间下很多菜。
 * 不同食材要煮不同的时间，才能变得刚好合适。你希望吃到最多的刚好合适的菜，但是你的手速不够快，用m代表手速，每次下手捞菜后至少要过m秒才能再捞（每
 * 次只能捞一个）。
 * 那么用最合理的策略，最多能吃到多少刚好合适的菜？
 * 输入描述：
 * 第一行两个整数n，m，其中n 代表往锅里下的菜的个数，m 代表手速。
 * 接下来有n行，每行有两个数x，y 代表第x秒下的菜过y秒才能变得刚好合适。
 * (1 < n,m < 1000)
 * (1 <x, y<1000)
 * 输出描述：2 1
 * 1 2
 * 2 1
 * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量
 * 示例1：
 * 输入
 * 2 1
 * 1 2
 * 2 1
 * 输出
 * 1
 */
public class 火锅 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer vegCount = 0;
        Integer sEatCount = 0;
        Set<Integer> set = new TreeSet<Integer>();
        Integer count = 0;
        while (scanner.hasNext()) {
            count++;
            int next = scanner.nextInt();
            if (count == 1) {
                vegCount = next;
            } else if (count == 2) {
                sEatCount = next;
            } else {
                if (count % 2 != 0) {
                    int s = scanner.nextInt();
                    Integer s1 = next + s;
                    set.add(s1);
                    count++;
                }
            }
            if (count == (vegCount + 1) * 2) {
                break;
            }
        }
        Integer[] a = new Integer[set.size()];
        a = set.toArray(a);
        Arrays.sort(a);
        Integer result = 0;
        Integer curents = a[0];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                result++;
                curents = a[i] + sEatCount;
            } else {
                if (a[i] > curents) {
                    result++;
                    curents = a[i] + sEatCount;
                }
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
