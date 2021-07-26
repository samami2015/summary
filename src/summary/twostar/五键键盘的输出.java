package summary.twostar;

import java.util.Scanner;

/**
 * 【5键键盘的输出】
 * 有一个特殊的5键键盘，上面有a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键。a键在屏幕上输出一个字母a；ctrl-c将当前选择的字母复制到剪贴板；ctrl-x
 * 将当前选择的字母复制到剪贴板，并清空选择的字母；ctrl-v将当前剪贴板里的字母输出到屏幕；ctrl-a选择当前屏幕上的所有字母。注意：
 * 1 剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
 * 2 当屏幕上没有字母时，ctrl-a无效
 * 3 当没有选择字母时，ctrl-c和ctrl-x无效
 * 4 当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
 * 给定一系列键盘输入，输出最终屏幕上字母的数量。
 * 输入描述：
 * 输入为一行，为简化解析，用数字1 2 3 4 5代表a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键的输入，数字用空格分隔
 * 输出描述：
 * 输出一个数字，为最终屏幕上字母的数量
 * 示例1：
 * 输入
 * 1 1 1
 * 输出
 * 3
 */
public class 五键键盘的输出 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String[] str = scanner.nextLine().trim().split(" ");
                String strPm = "";
                String strX = "";
                String strJ = "";
                for (int i = 0; i < str.length; i++) {
                    switch (Integer.parseInt(str[i])) {
                        case 1:
                            if (!strX.equals("")) {
                                strPm = "a";
                                strX = "";
                            } else {
                                strPm += "a";
                            }
                            break;
                        case 2:
                            if (!strX.equals("")) {
                                strJ = strX;
                            } else {
                                strJ = "";
                            }
                            break;
                        case 3:
                            if (!strX.equals("")) {
                                strJ = strX;
                                strPm = "";
                                strX = "";
                            } else {
                                strJ = "";
                            }
                            break;
                        case 4:
                            if (!strX.equals("")) {
                                strPm = strJ;
                            } else {
                                strPm += strJ;
                            }
                            break;
                        case 5:
                            if (!strPm.equals("")) {
                                strX = strPm;
                            }
                            break;
                    }
                }
                System.out.println(strPm.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
