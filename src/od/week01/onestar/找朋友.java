package od.week01.onestar;

import java.util.Scanner;

/**
 * 【找朋友】
 * 在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]，
 * 第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么j是i的好朋友(要求j > i)。
 * 请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。
 * 小朋友人数范围是 [0, 40000]。
 * <p>
 * 输入描述：
 * 第一行输入N，N表示有N个小朋友
 * 第二行输入N个小朋友的身高height[i]，都是整数
 * <p>
 * 输出描述：
 * 输出N个小朋友的好朋友的位置
 * <p>
 * 示例1：
 * 输入
 * 2
 * 100 95
 * 输出
 * 0 0
 */
public class 找朋友 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i += 1) {
            nums[i] = in.nextInt();
        }
        int[] result = new int[N];
        for (int i = N - 2; i >= 0; i -= 1) {
            int j = i + 1;
            while (true) {
                if (nums[j] > nums[i]) {
                    result[i] = j;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                } else {
                    j = result[j];
                }
            }
        }
        for (int i = 0; i < N; i += 1) {
            System.out.printf(result[i] + " ");
        }
    }
}
