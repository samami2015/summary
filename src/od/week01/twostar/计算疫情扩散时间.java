package od.week01.twostar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 【计算疫情扩散时间】
 * 在一个地图中(地图由n*n个区域组成），有部分区域被感染病菌。感染区域每天都会把周围（上下左右）的4个区域感染。
 * 请根据给定的地图计算，多少天以后，全部区域都会被感染。
 * 如果初始地图上所有区域全部都被感染，或者没有被感染区域，返回-1
 * <p>
 * 输入描述：
 * 一行N*N个数字（只包含0,1，不会有其他数字）表示一个地图，数字间用,分割，0表示未感染区域，1表示已经感染区域
 * 每N个数字表示地图中一行，输入数据共表示N行N列的区域地图。
 * 例如输入1,0,1,0,0,0,1,0,1，表示地图
 * 1,0,1
 * 0,0,0
 * 1,0,1
 * <p>
 * 输出描述：
 * 一个整数，表示经过多少天以后，全部区域都被感染
 * 备注：
 * 1<=N<200
 * 示例1：
 * 输入
 * 1,0,1,0,0,0,1,0,1
 * 输出
 * 2
 */
public class 计算疫情扩散时间 {
    static class Point {
        int x;
        int y;
        int generation;

        public Point(int x, int y, int generation) {
            this.x = x;
            this.y = y;
            this.generation = generation;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lines = line.split(",");
            int length = lines.length, normal = 0, sicks = 0, n = (int) Math.sqrt(length);
            int[][] graph = new int[n][n];
            Queue<Point> queue = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                int point = Integer.parseInt(lines[i]);
                if (point == 0) {
                    normal++;
                } else {
                    sicks++;
                    graph[i / n][i % n] = 1;
                    queue.add(new Point(i / n, i % n, 1));
                }
            }
            if (normal == length || sicks == length) {
                System.out.println(-1);
            } else {
                int days = 0;
                int generation = 1;
                while (sicks < length) {
                    Queue<Point> back = new LinkedList<>();
                    while (!queue.isEmpty()) {
                        Point point = queue.remove();
                        int x = point.x;
                        int y = point.y;
                        if (x >= 1 && graph[x - 1][y] == 0) {
                            graph[y - 1][y] = generation + 1;
                            back.add(new Point(x - 1, y, generation + 1));
                            sicks++;
                        }
                        if (x + 1 < n && graph[x + 1][y] == 0) {
                            graph[x + 1][y] = generation + 1;
                            back.add(new Point(x + 1, y, generation + 1));
                            sicks++;
                        }
                        if (y >= 1 && graph[x][y - 1] == 0) {
                            graph[x][y - 1] = generation + 1;
                            back.add(new Point(x, y - 1, generation + 1));
                            sicks++;
                        }
                        if (y + 1 < n && graph[x][y + 1] == 0) {
                            graph[x][y + 1] = generation + 1;
                            back.add(new Point(x, y + 1, generation + 1));
                            sicks++;
                        }
                    }
                    days++;
                    generation++;
                    queue = back;
                }
                System.out.println(days);
            }
        }
    }
}
