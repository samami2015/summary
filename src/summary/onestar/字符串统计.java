package summary.onestar;

import java.util.*;

/**
 * 【字符串统计】
 * 给定两个字符集合，一个为全量字符集，一个为已占用字符集。已占用的字符集中的字符不能再使用，要求输出剩余可用字符集。
 * 输入描述：
 * <p>
 * 1、输入为一个字符串，一定包含@符号。@前的为全量字符集，@后的字为已占用字符集。
 * 2、已占用字符集中的字符一定是全量字符集中的字符。字符集中的字符跟字符之间使用英文逗号分隔。
 * 3、每个字符都表示为字符加数字的形式，用英文冒号分隔，比如a:1，表示1个a字符。
 * 4、字符只考虑英文字母，区分大小写，数字只考虑正整形，数量不超过100。
 * 5、如果一个字符都没被占用，@标识仍然存在，例如a:3,b:5,c:2@
 * <p>
 * 输出描述：
 * <p>
 * 输出可用字符集，不同的输出字符集之间回车换行。
 * 注意，输出的字符顺序要跟输入一致。不能输出b:3,a:2,c:2
 * 如果某个字符已全被占用，不需要再输出。
 * 示例1：
 * 输入
 * a:3,b:5,c:2@a:1,b:2
 * 输出
 * a:2,b:3,c:2
 */
public class 字符串统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String[] strArr = str.split("@");
            List<String> charList = new ArrayList<>();
            Map<String, Integer> charSize = new HashMap<>();
            String[] FullArr = strArr[0].split(",");
            for (int i = 0; i < FullArr.length; i++) {
                String[] chars = FullArr[i].split(":");
                charSize.put(chars[0], Integer.valueOf(chars[1]));
                charList.add(chars[0]);
            }
            if (strArr.length > 1) {
                String[] occupyArr = strArr[1].split(",");
                for (int i = 0; i < occupyArr.length; i++) {
                    String[] chars = occupyArr[i].split(":");
                    if (charSize.containsKey(chars[0])) {
                        charSize.put(chars[0], charSize.get(chars[0]) - Integer.parseInt(chars[1]));
                    }
                }
            }
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < charList.size(); i++) {
                if (charSize.get(charList.get(i)) > 0) {
                    s.append(charList.get(i) + ":" + charSize.get(charList.get(i)) + ",");
                }
            }
            String result = "";
            if (s.length() > 0) {
                result = s.substring(0, s.length() - 1);
            }
            System.out.println(result);
        }
    }
}
