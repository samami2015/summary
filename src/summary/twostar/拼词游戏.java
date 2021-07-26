package summary.twostar;

import java.util.HashMap;
import java.util.Map;

/**
 * 【拼词游戏】
 * 给你一串字符串，可以任意调整字符的位置，请你算出最多可以拼出多少个helloWorld（区分大小写）。
 * 输入描述：
 * 输出描述：
 * 备注：
 * 1、字符元素范围：大小写字母和数字
 * 2、字符串长度：[0, 10000]
 * 示例1：
 * 输入
 * "hheellllo12oWWwoorrllddaabc"
 * 2
 */
public class 拼词游戏 {
    public static void main(String[] args) {
        拼词游戏 app = new 拼词游戏();
        String input = "hheellllo12oWWwoorrllddaabc";
        int res = app.helloWorldCount(input);
        System.out.println(res);
    }

    private static Map<Character, Integer> helloWorld = new HashMap<>();

    static {
        helloWorld.put('h', 1);
        helloWorld.put('e', 1);
        helloWorld.put('l', 3);
        helloWorld.put('o', 2);
        helloWorld.put('W', 1);
        helloWorld.put('r', 1);
        helloWorld.put('d', 1);
    }

    public static Boolean isNone(Map<Character, Integer> map) {
        return map.containsKey('h') &&
                map.containsKey('e') &&
                map.containsKey('l') &&
                map.containsKey('o') &&
                map.containsKey('W') &&
                map.containsKey('r') &&
                map.containsKey('d');
    }

    public int helloWorldCount(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        if (isNone(map)) {
            int min = map.get('h');
            for (Map.Entry<Character, Integer> tmp : helloWorld.entrySet()) {
                char key = tmp.getKey();
                Integer value = tmp.getValue();
                int a = map.get(key)/value;
                if(a<min){
                    min =a ;
                }
            }
            return min;
        }else {
            return 0;
        }
    }
}
