package summary.week.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 【数组去重和排序】
 * 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序。
 * 输入描述：
 * 一个数组
 * 输出描述：
 * 去重排序后的数组
 * 备注：
 * 数组大小不超过100
 * 数组元素值大小不超过100
 * 示例1：
 * 输入
 * 1,3,3,3,2,4,4,4,5
 * 输出
 * 3,4,1,2,5
 */
public class 数组去重和排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (null != (line = br.readLine())) {
            String[] arr = line.split(",");
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                Integer val = Integer.valueOf(arr[i]);
                if (set.add(val)) {
                    map.put(val, 1);
                    list.add(val);
                } else {
                    map.put(val, map.get(val) + 1);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size() - 1 - i; j++) {
                    Integer eleI = map.get(list.get(j));
                    Integer eleJ = map.get(list.get(j + 1));
                    if (eleJ > eleI) {
                        int temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(",").append(list.get(i));
            }
            System.out.println(sb.substring(1));
        }
    }
}
