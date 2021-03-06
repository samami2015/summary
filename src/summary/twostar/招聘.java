package summary.twostar;

import java.util.*;

/**
 * 【招聘】
 * 某公司组织一场公开招聘活动，假设由于人数和场地的限制，每人每次面试的时长不等，并已经安排给定，用(S1,E1)、(S2,E2)、(Sj,Ej)...(Si < Ei，均为非
 * 负整数)表示每场面试的开始和结束时间。面试采用一对一的方式，即一名面试官同时只能面试一名应试者，一名面试官完成一次面试后可以立即进行下一场面试，
 * 且每个面试官的面试人次不超过m。
 * 为了支撑招聘活动高效顺利进行，请你计算至少需要多少名面试官。
 * <p>
 * 输入描述：
 * 输入的第一行为面试官的最多面试人次m，第二行为当天总的面试场次n，接下来的n行为每场面试的起始时间和结束时间，起始时间和结束时间用空格分隔。
 * 其中，1 <= n, m <= 500
 * <p>
 * 输出描述：
 * 输出一个整数，表示至少需要的面试官数量。
 * <p>
 * 示例1：
 * 输入
 * 2
 * 5
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * <p>
 * 输出
 * 3
 */
public class 招聘 {
    static class Node {
        int a;
        int b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < nodes.length; i++) {
                Node node = new Node();
                node.a = sc.nextInt();
                node.b = sc.nextInt();
                nodes[i] = node;
            }
            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    int a = o1.a - o2.a;
                    if (a == 0) {
                        a = o1.b - o2.b;
                    }
                    return a;
                }
            });

            List<Node> list = new ArrayList<>();
            for (int i = 0; i < nodes.length; i++) {
                Node reporter = null;
                for (Node node : list) {
                    if (node.a != m && node.b <= nodes[i].a) {
                        reporter = node;
                        reporter.a = reporter.a + 1;
                        reporter.b = nodes[i].b;
                        break;
                    }
                }
                if (reporter == null) {
                    reporter = new Node();
                    list.add(reporter);
                    reporter.b = nodes[i].b;
                    reporter.a = 1;
                }
            }
            System.out.println(list.size());
        }
    }
}
