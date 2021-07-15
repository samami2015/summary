package od.summary.week01.onestar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【字符串分割】
 * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。对于
 * 新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，如果它含有的大写字母比小写字母多，则将这个
 * 子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
 * <p>
 * 输入描述：
 * 输入为两行，第一行为参数K，第二行为字符串S。
 * 输出描述：
 * 输出转换后的字符串。
 * <p>
 * 示例1：
 * 输入
 * 3
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 */
public class 字符串分割 {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = Integer.parseInt(scanner.nextLine());
                String line = scanner.nextLine();
                int index = line.indexOf('-');
                String first = line.substring(0, index);
                String rest = line.substring(index + 1).replace("-", "");
                StringBuilder builder = new StringBuilder(first);
                char[] arr = rest.toCharArray();
                int start = 0, end = n > arr.length ? arr.length : n;
                while (start < arr.length) {
                    char[] data = Arrays.copyOfRange(arr, start, end);
                    int bc = 0, mc = 0;
                    for (int i = 0; i < data.length; i++) {
                        if (data[i] >= 'a' && data[i] <= 'z') {
                            mc++;
                        } else if (data[i] >= 'A' && data[i] <= 'Z') {
                            bc++;
                        }
                    }
                    int sp = bc - mc;
                    if (sp != 0) {
                        for (int i = 0; i < data.length; i++) {
                            if (data[i] >= 'a' && data[i] <= 'z') {
                                if (sp > 0) {
                                    data[i] -= 32;
                                }
                            } else if (data[i] >= 'A' && data[i] <= 'Z') {
                                if (sp < 0) {
                                    data[i] += 32;
                                }
                            }
                        }
                    }
                    builder.append("-").append(new String(data));
                    start += n;
                    end += n;
                    if (end > arr.length) {
                        end = arr.length;
                    }
                }
                System.out.println(builder.toString());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
