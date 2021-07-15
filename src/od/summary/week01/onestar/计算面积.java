package od.summary.week01.onestar;

import java.util.Scanner;

/**
 * 【计算面积】
 * 绘图机器的绘图笔初始位置在原点（0, 0），机器启动后其绘图笔按下面规则绘制直线：
 * 1）尝试沿着横向坐标轴正向绘制直线，直到给定的终点值E。
 * 2）期间可通过指令在纵坐标轴方向进行偏移，并同时绘制直线，偏移后按规则1 绘制直线；指令的格式为X offsetY，表示在横坐标X 沿纵坐标方向偏移，offsetY为
 * 正数表示正向偏移，为负数表示负向偏移。
 * 给定了横坐标终点值E、以及若干条绘制指令，请计算绘制的直线和横坐标轴、以及 X=E 的直线组成图形的面积。
 * <p>
 * 输入描述：
 * 首行为两个整数 N E，表示有N条指令，机器运行的横坐标终点值E。
 * 接下来N行，每行两个整数表示一条绘制指令X offsetY，用例保证横坐标X以递增排序方式出现，且不会出现相同横坐标X。
 * 取值范围：0 < N <= 10000, 0 <= X <= E <=20000, -10000 <= offsetY <= 10000。
 * <p>
 * 输出描述：
 * 一个整数，表示计算得到的面积，用例保证，结果范围在0~4294967295内
 * <p>
 * 示例1：
 * 输入
 * 4 10
 * 1 1
 * 2 1
 * 3 1
 * 4 -2
 * 输出
 * 12
 */
public class 计算面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = scanner.nextInt();
        int endX = scanner.nextInt();
        int nowX = 0;
        int nowY = 0;
        long result = 0;
        for (int i = 0; i < commandCount; i++) {
            int currentX = scanner.nextInt();
            result = result + Math.abs(nowY) * (currentX - nowX);
            nowX = currentX;
            nowY = nowY + scanner.nextInt();
        }
        result = result + (endX - nowX) * Math.abs(nowY);
        System.out.println(result);
    }
}
