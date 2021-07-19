package summary.onestar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【最远足迹】
 * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。探索工作
 * 结束后，探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 * 1. 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<x<1000，0<y<1000。同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
 * 2. 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为：x*x+y*y。
 * 3. 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 4. 若记录仪中的坐标都不合法，输出总部坐标（0,0）。
 * 备注：不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
 * 输入描述：
 * 字符串，表示记录仪中的数据。
 * 如：ferga13fdsf3(100,200)f2r3rfasf(300,400)
 * 输出描述：
 * 字符串，表示最远足迹到达的坐标。
 * 如： (300,400)
 * 示例1：
 * 输入
 * ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
 * 输出
 * (5,10)
 */
public class 最远足迹 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String coordinateStr = sc.next();
            getCoordinate(coordinateStr);
        }
    }

    private static void getCoordinate(String coordinateStr) {
        List<String> points = new ArrayList<>();
        getPoints(points, coordinateStr);
        int maxPoint = -1;
        int maxArea = 0;
        for (int i = 0; i < points.size(); i++) {
            String[] point = points.get(i).split(",");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            if (point[0].startsWith("0") || point[1].startsWith("0")) {
                continue;
            }
            if (0 < x && x < 1000 && 0 < y && y < 1000) {
                int area = x * x + y * y;
                if (area > maxArea) {
                    maxArea = area;
                    maxPoint = i;
                }
            }
        }
        if (maxPoint == -1) {
            System.out.println("0,0");
        } else {
            System.out.println(String.format("(%s)", points.get(maxPoint)));
        }
    }

    private static void getPoints(List<String> points, String coordinateStr) {
        int sPoint = coordinateStr.indexOf('(');
        int endPoint = coordinateStr.indexOf(')');
        if (sPoint > -1 && endPoint > -1) {
            points.add(coordinateStr.substring(sPoint + 1, endPoint));
            String nextStr = coordinateStr.substring(endPoint + 1);
            getPoints(points, nextStr);
        }
    }
}
