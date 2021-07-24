package summary.week.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【找出丢包的编号】
 * A和B进行通信，A向B发送了从0到N的N+1连续编号的数据包，由于网络原因，B收到了N个数据包，请找出传输过程中丢掉的那个包的编号。
 * 输入描述：
 * 收到包的顺序可以与发送顺序不同。0<=N<10000;
 * 输出描述：
 * 从A到B传输过程中丢掉包的编号
 * 示例1：
 * 输入
 * [0,1,2,4,5]
 * 输出
 * 3
 */
public class 找出丢包的编号 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String str = "";
        StringBuffer sf = new StringBuffer();
        while ((str = br.readLine()) != null||!"".equals(str)) {
            if (str == null || "".equals(str.trim())) {
                break;
            }
            sf.append(str);
        }
        String[] array = sf.toString().replace("[", "").replace(",,", ",").split("]");
        for (int k = 0; k < array.length; k++) {
            str = array[k];
            String[] ss = str.split(",");
            List<String> list1 = Arrays.asList(ss);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                list.add(list1.get(i).trim());
            }
            String temp = String.valueOf(ss.length);
            for (int i = 0; i <= ss.length; i++) {
                if (!list.contains(String.valueOf(i))) {
                    temp = String.valueOf(i);
                    break;
                }
            }
            System.out.println(temp);
        }
        br.close();
    }
}
