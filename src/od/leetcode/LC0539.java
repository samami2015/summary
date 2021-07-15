package od.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0539 {
    public static void main(String[] args) {
        LC0539 solution = new LC0539();
        List<String> timePoints = new ArrayList<>();
//        timePoints.add("23:59");
//        timePoints.add("00:00");
        timePoints.add("00:00");
        timePoints.add("23:59");
        timePoints.add("00:00");
        int ans = solution.findMinDifference(timePoints);
        System.out.println(ans);
    }

    public int findMinDifference(List<String> timePoints) {
        // 一天有 1440 分钟，如果 timePoints >= 1440 则表示有相等的时间，时间差为 0
        if (timePoints.size() >= 1440) {
            return 0;
        }
        // 用来存储每个时间的分钟
        int[] array = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            array[i] = minute(timePoints.get(i));
        }
        // 排序
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            // 求出分钟差
            min = Math.min(min, array[i] - array[i - 1]);
            // 如果有最小分钟差，则直接返回
            if (min == 0) {
                return 0;
            }
        }
        // 最大时间和最小时间的分钟差可能最小，需要判断一下
        return Math.min(min, 1440 + array[0] - array[array.length - 1]);
    }

    //["23:59","00:00"]
    public int minute(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }
}
