package summary.onestar;

import java.util.Scanner;

/**
 * 【集五福】
 * 集五福作为近年来大家喜闻乐见迎新春活动，集合爱国福、富强福、和谐福、友善福、敬业福即可分享超大红包
 * 以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡，单类型福卡不超过1张，随机抽取一个不超过10人团队，求
 * 该团队最多可以集齐多少套五福
 * <p>
 * 输入描述：
 * 输入类似11010,00110，由0、1组成的长度为5的字符串，代表指定团队中每个人福卡获得情况
 * 注意1：1人也可以是一个团队
 * 注意2：多人之间的福卡以英文逗号隔开
 * <p>
 * 输出描述：
 * 输出该团队能凑齐多少套五福
 * <p>
 * 示例1：
 * 输入
 * 11001,11100
 * 输出
 * 0
 */
public class 集五福 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] list = str.split(",");
        int result[] = {0, 0, 0, 0};
        for (String temp : list) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + Integer.parseInt(String.valueOf(temp.charAt(i)));
            }
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < result.length; i++) {
            count = Math.min(count, result[i]);
        }
        System.out.println(count);
    }
}
