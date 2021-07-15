package od.summary.week01.twostar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 【考古学家】
 * 有一个考古学家发现一个石碑，但是很可惜，发现时其已经断成多段，原地发现n个断口整齐的石碑碎片。为了破解石碑内容，考古学家希望有程序能
 * 帮忙计算复原后的石碑文字组合数，你能帮忙吗？
 * <p>
 * 输入描述：
 * 第一行输入n，n表示石碑碎片的个数。
 * 第二行依次输入石碑碎片上的文字内容s，共有n组。
 * <p>
 * 输出描述：
 * 输出石碑文字的组合（按照升序排列），行末无多余空格。
 * <p>
 * 备注：
 * 如果存在石碑碎片内容完全相同，则由于碎片间的顺序变换不影响复原后的碑文内容，即相同碎片间的位置变换不影响组合。
 * <p>
 * 示例1：
 * 输入
 * 3
 * a b c
 * 输出
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 */
public class 考古学家 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while ((sc.hasNext())) {
            int a = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                String str = sc.next();
                list.add(str);
            }
            List<StringBuilder> results = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            test3(stringBuilder, list, results);
            results.sort(new Comparator<StringBuilder>() {
                @Override
                public int compare(StringBuilder o1, StringBuilder o2) {
                    String s1 = o1.toString();
                    String s2 = o2.toString();
                    char[] chars1 = s1.toCharArray();
                    char[] chars2 = s2.toCharArray();
                    if (chars1.length != chars2.length) {
                        return chars1.length - chars2.length;
                    } else {
                        for (int i = 0; i < chars1.length; i++) {
                            if (chars1[i] < chars2[i]) {
                                return -1;
                            } else if (chars1[i] > chars2[i]) {
                                return 1;
                            }
                        }
                    }
                    return 0;
                }
            });
            for (int i = 0; i < results.size(); i++) {
                if (i == 0 || !results.get(i).toString().equals(results.get(i - 1).toString())) {
                    System.out.println(results.get(i));
                }
            }
        }
    }

    private static void test3(StringBuilder stringBuilder, List<String> list, List<StringBuilder> results) {
        for (int i = 0; i < list.size(); i++) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(stringBuilder.toString() + list.get(i));
            if (list.size() > 1) {
                List<String> newList = new ArrayList<>();
                newList.addAll(list);
                newList.remove(i);
                test3(stringBuilder1, newList, results);
            } else {
                results.add(stringBuilder1);
            }
        }
    }
}
