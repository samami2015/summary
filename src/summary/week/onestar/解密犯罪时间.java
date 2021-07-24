package summary.week.onestar;

import java.util.*;

/**
 * 【解密犯罪时间】
 * 警察在侦破一个案件时，得到了线人给出的可能犯罪时间，形如 “HH:MM” 表示的时刻。
 * 根据警察和线人的约定，为了隐蔽，该时间是修改过的，解密规则为：利用当前出现过的数字，构造下一个距离当前时间最近的时刻，则该时间为可能的犯罪时间。
 * 每个出现数字都可以被无限次使用。
 * 输入描述：
 * 形如HH:SS的字符串，表示原始输入
 * 输出描述：
 * 形如HH:SS的字符串，表示推理出来的犯罪时间
 * 备注：
 * 1. 可以保证线人给定的字符串一定是合法的。例如，“01:35” 和 “11:08” 是合法的，“1:35” 和 “11:8” 是不合法的。
 * 2. 最近的时刻有可能在第二天。
 * 示例1：
 * 输入
 * 18:52
 * 输出
 * 18:55
 */
public class 解密犯罪时间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String nums = str.replace(":", "");
            int[] numArr = new int[4];
            for (int i = 0; i < nums.length(); i++) {
                numArr[i] = Integer.parseInt(nums.charAt(i) + "");
            }
            Set<Integer> hourSet = new HashSet<>();
            Set<Integer> minuteSet = new HashSet<>();
            for (int i = 0; i < numArr.length; i++) {
                for (int j = 0; j < numArr.length; j++) {
                    hourSet.add(numArr[i] * 10 + numArr[j]);
                }
            }
            for (int i = 0; i < numArr.length; i++) {
                for (int j = 0; j < numArr.length; j++) {
                    minuteSet.add(numArr[i] * 10 + numArr[j]);
                }
            }
            Iterator<Integer> iterator = hourSet.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() > 23) {
                    iterator.remove();
                }
            }
            iterator = minuteSet.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() > 59) {
                    iterator.remove();
                }
            }
            Iterator<Integer> hiterator = hourSet.iterator();
            List<String> list = new ArrayList<>();
            while (hiterator.hasNext()) {
                int hour = hiterator.next();
                Iterator<Integer> mterator = minuteSet.iterator();
                while (mterator.hasNext()) {
                    int minute = mterator.next();
                    list.add((hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            int index = list.indexOf(str);
            if (index != list.size() - 1) {
                System.out.println(list.get(index + 1));
            } else {
                System.out.println(list.get(0));
            }
        }
    }
}
