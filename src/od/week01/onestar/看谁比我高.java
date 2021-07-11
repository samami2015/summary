package od.week01.onestar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【看谁比我高】
 * 幼儿园开学，老师为了促进小朋友的交流，设置一个游戏，N个围成一圈，每个小朋友按顺序找出第一个比自己高的人。
 * 如果存在比自己高的人，就输出第一个比自己高的身高，如果不存在，则输出-1。
 * <p>
 * 输入描述：
 * 代表N（2≤N≤500）个人的身高数组，身高的取值范围[30,100]
 * 输出描述：
 * 返回一个等长的数组，对应索引存储着下一个更高的身高，如果没有更高的，就存-1
 * <p>
 * 示例1：
 * 输入
 * [49, 48, 49, 53, 51]
 * 输出
 * [53, 49, 53, -1, 53]
 */
public class 看谁比我高 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] c = line.substring(1, line.length() - 1).split(", ");
        int[] heights = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            heights[i] = Integer.parseInt(c[i]);
        }
        int[] ans = nextHigherInCircle(heights);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextHigherInCircle(int[] heights) {
        int length = heights.length;
        int max = heights[0];
        for (int i = 0; i < length; i++) {
            max = heights[i] > max ? heights[i] : max;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (heights[i] == max) {
                result[i] = -1;
            } else {
                int count = 0;
                for (int j = i + 1; count < length; j++) {
                    count++;
                    if (j >= length) {
                        j = 0;
                    }
                    if (heights[j] > heights[i]) {
                        result[i] = heights[j];
                        break;
                    }
                }
            }
        }
        return result;
    }
}
