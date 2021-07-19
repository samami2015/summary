package summary.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 【快递运输】
 * 一辆运送快递的货车，运送的快递均放在大小不等的长方体快递盒中，为了能够装载更多的快递，同时不能让货车超载，需要计算最多能装多少个快递。
 * 注：快递的体积不受限制，快递数最多1000个，货车载重最大50000。
 * 输入描述：
 * 第一行输入每个快递的重量，用英文逗号分隔，如：5,10,2,11
 * 第二行输入货车的载重量，如：20
 * 不需要考虑异常输入。
 * <p>
 * 输出描述：
 * 输出最多能装多少个快递，如：3
 * <p>
 * 示例1：
 * 输入
 * 5,10,2,11
 * 20
 * 输出
 * 3
 */
public class 快递运输 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strs = line.split(",");
        Integer[] nums = new Integer[strs.length];
        Integer sum = Integer.parseInt(br.readLine());
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(nums);
        int count = 0;
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum = tempSum + nums[i];
            if (tempSum <= sum) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
