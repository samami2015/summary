package summary.plus.twostar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【采样过滤】
 * 在做物理实验时，为了计算物体移动的速率，通过相机等工具周期性的采样物体移动距离。由于工具故障，采样数据存在误差甚至错误的情况。需要通过一个算法过
 * 滤掉不正确的采样值。不同工具的故障模式存在差异，算法的各类门限会根据工具类型做相应的调整。请实现一个算法，计算出给定一组采样值中正常值的最长连续
 * 周期。
 * 判断第i个周期的采样数据S[i]是否正确的规则如下（假定物体移动速率不超过10个单元,前一个采样周期S[i-1])：
 * S[i] <= 0，即为错误值
 * S[i] < S[i-1]，即为错误值
 * S[i] - S[i-1] >= 10，即为错误值
 * 其它情况为正常值
 * 判断工具是否故障的规则如下：
 * 在M个周期内，采样数据为错误值的次数为T（次数可以不连续），则工具故障。
 * 判断故障恢复的条件如下：
 * 产生故障后的P个周期内，采样数据一直为正常值，则故障恢复。
 * 错误采样数据的处理方式：
 * 检测到故障后，丢弃从故障开始到故障恢复的采样数据。
 * 在检测到工具故障之前，错误的采样数据，则由最近一个正常值代替；如果前面没有正常的采样值，则丢弃此采样数据。
 * 给定一段周期的采样数据列表S，计算正常值的最长连续周期。
 * <p>
 * 输入描述：
 * 故障确认周期数和故障次数门限分别为M和T，故障恢复周期数为P。
 * 第i个周期，检测点的状态为Si
 * 输入为两行，格式如下：
 * M T P
 * S1 S2 S3 ...
 * M、T和P的取值范围为[1, 100000]
 * Si取值范围为[0, 100000]，i从0开始编号
 * <p>
 * 输出描述：
 * 一行输出正常值的最长连续周期
 * 示例1：
 * 输入
 * 10 6 3
 * -1 1 2 3 100 10 13 9 10
 * 输出
 * 8
 */
public class 采样过滤 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] lineArr1 = sc.nextLine().split(" ");
            String[] lineArr2 = sc.nextLine().split(" ");
            int m = Integer.parseInt(lineArr1[0]);
            int t = Integer.parseInt(lineArr1[1]);
            int p = Integer.parseInt(lineArr1[2]);
            ArrayList<Integer> list = new ArrayList<>();
            int max = 0;
            int error = 0;
            int lastRight = -1;
            boolean signal = true;
            int signalCount = 0;
            boolean flag = true;
            for (String str : lineArr2) {
                int num = Integer.parseInt(str);
                if (num <= 0) {
                    flag = false;
                } else if (list.size() > 0) {
                    int sub = num - lastRight;
                    if (num < 0 || num >= 10) {
                        flag = false;
                    }
                }
                if (flag) {
                    if (signal) {
                        max++;
                        lastRight = num;
                    } else {
                        signalCount++;
                        if (signalCount == p) {
                            lastRight = num;
                            max += signalCount;
                            signalCount = 0;
                            signal = true;
                        }
                    }
                    list.add(num);
                } else {
                    signalCount = 0;
                    error++;
                    if (list.size() > 0) {
                        if (lastRight > 0) {
                            list.add(lastRight);
                        }
                    }
                    if (error == t) {
                        signal = false;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
