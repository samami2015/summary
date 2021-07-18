package summary.twostar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 【数据最节约的备份方法】
 * 有若干个文件，使用刻录光盘的方式进行备份，假设每张光盘的容量是500MB，求使用光盘最少的文件分布方式
 * 所有文件的大小都是整数的MB，且不超过500MB；文件不能分割、分卷打包
 * 输入描述：
 * 一组文件大小的数据
 * 输出描述：
 * 使用光盘的数量
 * 备注：
 * 不用考虑输入数据不合法的情况；假设最多100个输入文件。
 * 示例1：
 * 输入
 * 100,500,300,200,400
 * 输出
 * 3
 */
public class 数据最节约的备份方法 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(",");
            if (str.length == 0) {
                System.out.println(0);
            } else if (str.length == 1) {
                System.out.println(1);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < str.length; i++) {
                    list.add(Integer.valueOf(str[i]));
                }
                Collections.sort(list);
                list(list);
                System.out.println(count);
                count = 0;
            }
        }
    }

    private static void list(List<Integer> list) {
        int length = list.size();
        if (length == 1) {
            count++;
        }
        if (length == 2) {
            if (list.get(0) + list.get(1) > 500) {
                count = count + 2;
            } else {
                count++;
            }
        }
        if (length > 2) {
            int sum = list.get(length - 1);
            for (int i = list.size() - 1; i >= 0; i--) {
                if (sum == 500) {
                    count++;
                    list.remove(i);
                    list(list);
                    break;
                } else {
                    boolean flag = false;
                    for (int j = 0; j < length - 1; j++) {
                        sum = sum + list.get(j);
                        if (sum > 500) {
                            for (int k = 0; k < j; k++) {
                                list.remove(0);
                            }
                            list.remove(list.size() - 1);
                            count++;
                            list(list);
                            flag = true;
                            break;
                        }
                        if (sum == 500) {
                            for (int k = 0; k <= j; k++) {
                                list.remove(0);
                            }
                            list.remove(list.size() - 1);
                            count++;
                            list(list);
                            flag = true;
                            break;
                        }
                        if ((j == length - 2) && sum < 500) {
                            count++;
                            return;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
        }
    }
}
