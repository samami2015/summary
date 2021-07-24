package summary.week.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 【数据分类】
 * 对一个数据a进行分类，分类方法为：此数据a（四个字节大小）的四个字节相加对一个给定的值b取模，如果得到的结果小于一个给定的值c，则数据a为有效类型，
 * 其类型为取模的值；如果得到的结果大于或者等于c，则数据a为无效类型。
 * 比如一个数据a=0x01010101，b=3，按照分类方法计算（0x01+0x01+0x01+0x01）%3=1，所以如果c=2，则此a为有效类型，其类型为1，如果c=1，则此a为无效
 * 类型；
 * 又比如一个数据a=0x01010103，b=3，按照分类方法计算（0x01+0x01+0x01+0x03）%3=0，所以如果c=2，则此a为有效类型，其类型为0，如果c=0，则此a为无
 * 效类型。
 * 输入12个数据，第一个数据为c，第二个数据为b，剩余10个数据为需要分类的数据，请找到有效类型中包含数据最多的类型，并输出该类型含有多少个数据。
 * 输入描述：
 * 输入12个数据，用空格分隔，第一个数据为c，第二个数据为b，剩余10个数据为需要分类的数据。
 * 输出描述：
 * 输出最多数据的有效类型有多少个数据。
 * 示例1：
 * 输入
 * 3 4 256 257 258 259 260 261 262 263 264 265
 * 输出
 * 3
 */
public class 数据分类 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().split(" ");
        Map<Integer, Integer> rs = new HashMap<>();
        int c = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int max = 0;
        for (int i = 2; i < strs.length; i++) {
            int num = Integer.parseInt(strs[i]);
            int num1 = num / (256 * 256 * 256);
            int num2 = (num % (256 * 256 * 256)) / (256 * 256);
            int num3 = (num % (256 * 256)) / 256;
            int num4 = num % 256;
            if ((num1 + num2 + num3 + num4) % b < c) {
                Integer key = (num1 + num2 + num3 + num4) % b;
                if (!rs.containsKey(key)) {
                    rs.put(key, 0);
                }
                rs.put(key, rs.get(key) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> s = rs.entrySet();
        for (Map.Entry<Integer, Integer> o : s) {
            max = Math.max(o.getValue(), max);
        }
        System.out.println(max);
    }
}
