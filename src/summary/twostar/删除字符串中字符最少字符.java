package summary.twostar;

import java.util.*;

/**
 * 【删除字符串中字符最少字符】删除字符串中出现次数最少的字符，如果有多个字符出现次数一样，则都删除。
 * 输入描述：
 * 输入abcdd
 * 字符串中只包含小写英文字母。
 * 输出描述：
 * dd
 * 示例1：
 * 输入
 * abcdd
 * 输出
 * dd
 */
public class 删除字符串中字符最少字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list = findMinNumberChar(str);
        for (String s : list) {
            str = str.replace(s, "");
        }
        if (str.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(str);
        }
    }

    private static List<String> findMinNumberChar(String str) {
        char[] chars = str.toCharArray();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (char s : chars) {
            if (map.get(String.valueOf(s)) == null) {
                map.put(String.valueOf(s), 1);
            } else {
                int num = map.get(String.valueOf(s)) + 1;
                map.put(String.valueOf(s), num);
            }
        }
        Iterator<Integer> iter = map.values().iterator();
        int minNum = Integer.MAX_VALUE;
        while (iter.hasNext()) {
            Integer num = iter.next();
            if (num < minNum) {
                minNum = num;
            }
        }
        List<String> strs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minNum == entry.getValue() && !strs.contains(entry.getKey())) {
                strs.add(entry.getKey());
            }
        }
        return strs;
    }
}
