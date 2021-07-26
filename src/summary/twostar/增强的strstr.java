package summary.twostar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【增强的strstr】
 * C 语言有一个库函数： char *strstr(const char *haystack, const char *needle) ，实现在字符串 haystack 中查找第一次出现字符串 needle 的位置，如果未找到则返回
 * null。
 * 现要求实现一个strstr的增强函数，可以使用带可选段的字符串来模糊查询，与strstr一样返回首次查找到的字符串位置。
 * 可选段使用“[]”标识，表示该位置是可选段中任意一个字符即可满足匹配条件。比如“a[bc]”表示可以匹配“ab”或“ac”。
 * 注意目标字符串中可选段可能出现多次。
 * 输入描述：
 * 与strstr函数一样，输入参数是两个字符串指针，分别是源字符串和目标字符串。
 * 输出描述：
 * 与strstr函数不同，返回的是源字符串中，匹配子字符串相对于源字符串地址的偏移（从0开始算），如果没有匹配返回-1。
 * 备注：
 * 源字符串中必定不包含‘[]’；目标字符串中‘[]’必定成对出现，且不会出现嵌套。
 * 输入的字符串长度在[1,100]之间。
 * 示例1：
 * 输入
 * abcd
 * b[cd]
 * 输出
 * 1
 */
public class 增强的strstr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String str2 = scanner.nextLine();
            qz(str, str2);
        }
    }

    static List<String> list = new ArrayList<>();

    public static void qz(String str, String str2) {
        list = new ArrayList<>();
        str2 = str2.replaceAll("\\[", ",[").replaceAll("\\]", ",");
        String[] q = str2.split(",");
        String head = q[0];
        int ret = 1;
        list.add(head);
        for (int i = 1; i < q.length; i++) {
            zf(q[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            int re = str.indexOf(list.get(i));
            if (re != -1) {
                if (ret == -1) {
                    ret = re;
                } else if (re < ret) {
                    ret = re;
                }
            }
        }
        System.out.println(ret);
    }

    public static void zf(String str) {
        List<String> arr = new ArrayList<>();
        if (str.indexOf("[") != -1) {
            str = str.replaceAll("\\[]", "");
            char[] cs = str.toCharArray();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < cs.length; j++) {
                    arr.add(list.get(i) + cs[j]);
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                arr.add(list.get(i) + str);
            }
        }
        list = arr;
    }
}
