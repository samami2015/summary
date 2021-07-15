package od.summary.week01.onestar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 【分配土地】
 * 从前有个村庄，村民们喜欢在各种田地上插上小旗子，旗子上标识了各种不同的数字。某天集体村民决定将覆盖相同数字的最小矩阵形的土地的分配给
 * 为村里做出巨大贡献的村民，请问，此次分配土地，做出贡献的村民中最大会分配多大面积？
 * <p>
 * 输入描述：
 * 第一行输入m和n，m代表村子的土地的长，n代表土地的宽
 * 第二行开始输入地图上的具体标识
 * <p>
 * 输出描述：
 * 输出需要分配的土地面积，即包含相同数字旗子的最小矩阵中的最大面积。
 * <p>
 * 备注：
 * 旗子上的数字为1-500，土地边长不超过500
 * 未插旗子的土地用0标识
 * <p>
 * 示例1：
 * 输入
 * 3 3
 * 1 0 1
 * 0 0 0
 * 0 1 0
 * 输出
 * 9
 */
public class 分配土地 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] split = scanner.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            HashMap<Integer, List<Integer>> myMap = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; i++) {
                String[] oneLine = scanner.nextLine().split(" ");
                for (int j = 0; j < oneLine.length; j++) {
                    int redFlag = Integer.parseInt(oneLine[j]);
                    if (redFlag != 0) {
                        if (myMap.getOrDefault(redFlag, null) != null) {
                            List<Integer> list = myMap.get(redFlag);
                            if (j < list.get(0)) {
                                list.set(0, j);
                            }
                            if (j > list.get(2)) {
                                list.set(2, j);
                            }
                            list.set(3, i);
                        } else {
                            ArrayList<Integer> flagList = new ArrayList<Integer>();
                            flagList.add(j);
                            flagList.add(i);
                            flagList.add(j);
                            flagList.add(i);
                            myMap.put(redFlag, flagList);
                        }
                    }
                }
            }
            int maxMap = 0;
            for (List<Integer> flagMap : myMap.values()) {
                int get = (flagMap.get(2) - flagMap.get(0) + 1) * (flagMap.get(3) - flagMap.get(1) + 1);
                if (get > maxMap) {
                    maxMap = get;
                }
            }
            if (maxMap == 0) {
                System.out.println(1);
            } else {
                System.out.println(maxMap);
            }
        }
    }
}
