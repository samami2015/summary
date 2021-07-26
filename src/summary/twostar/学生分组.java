package summary.twostar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 【学生分组】
 * 某个班级有若干名学生，每个学生随机抽取一个数字，班级里所有学生的数字用数组表示，先要求对学生分组
 * 1.每组内都有n个学生
 * 2.每组内学生的数字都相同
 * 3.输出的分组按照分组内学生数字升序排列
 * 4.满足以上条件的情况下，数字相同的学生尽量在同一个分组
 * 如果可以对学生进行分组，且n>2，则返回分组结果；否则返回空数组
 * 输入描述：
 * 输出描述：
 * 备注：
 * 学生数量范围：[2, 100]
 * 每个分组学生个数n取值范围：[2, 100]
 * 示例1：
 * 输入
 * [1,2,5,4,4,5,2,1]
 * 输出
 * [[1,1],[2,2],[4,4],[5,5]]
 */
public class 学生分组 {
    public static void main(String[] args) {
        学生分组 app = new 学生分组();
        int[] students = {1,2,5,4,4,5,2,1};
        int[][] res = app.group(students);
        for(int[] arr:res){
            System.out.println(Arrays.toString(arr));
        }
    }
    public int[][] group(int[] students) {
        Arrays.sort(students);
        Map<Integer, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int value : students) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            set.add(entry.getValue());
        }
        int n = getMaxyueshu(set);
        if (n == -1 || n < 2) {
            return new int[0][0];
        }
        int k = 0;
        int[][] vv = new int[students.length / n][n];
        for (int i = 0; i < vv.length; i++) {
            for (int j = 0; j < n; j++) {
                vv[i][j] = students[k];
                k++;
            }
        }
        return vv;
    }

    private static int getMaxyueshu(Set<Integer> set) {
        List<Integer> list = new ArrayList<>();
        set.stream().forEach(value -> {
            list.add(value);
        });
        List<Integer> li = list.stream().sorted().collect(Collectors.toList());
        int i = li.get(0);
        for (int v : li) {
            if (v % i != 0) {
                return -1;
            }
        }
        return i;
    }
}
