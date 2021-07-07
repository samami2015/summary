package od.week01.onestar;

import java.util.*;

/**
 * 【字符统计及重排】给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，并按照字母出现次数从大到小的顺序输出各个
 * 字母及其出现次数。如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
 * <p>
 * 输入描述：
 * 输入一行，为一个仅包含字母的字符串。
 * 输出描述：
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号；字母和次数间用英文冒号分隔。
 * 示例1：
 * 输入
 * xyxyXX
 * 输出
 * x:2;y:2;X:2;
 */
public class 字符统计及重排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(getResult(str));
        }
    }

    private static String getResult(String str) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> {
            if (e2.getValue().equals(e1.getValue())) {
                if ((e1.getKey() < 'a' && e2.getKey() > 'Z') || (e2.getKey() < 'a') && e1.getKey() > 'Z') {
                    return e2.getKey() - e1.getKey();
                } else {
                    return e1.getKey() - e2.getKey();
                }
            } else {
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : list) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        return sb.toString();
    }
}
