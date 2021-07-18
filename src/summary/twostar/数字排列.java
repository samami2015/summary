package summary.twostar;

import java.util.*;

/**
 * 小明负责公司年会，想出一个趣味游戏：
 * 屏幕给出1～9中任意3个不重复的数字，大家以最快时间给出这几个数字可拼成的数字从小到大排列位于第N位置的数字，其中N为给出的数字中最大的（如果不到这
 * 么多个数字则给出最后一个即可）。
 * 注意：
 * 1）2可以当做5来使用，5也可以当做2来使用进行数字拼接，且屏幕不能同时给出2和5；
 * 2）6可以当做9来使用，9也可以当做6来使用进行数字拼接，且屏幕不能同时给出6和9。
 * 如给出：1，4，8，则可以拼成的数字为：
 * 1，4，8，14，18，41，48，81，84，148，184，418，481，814，841
 * 那么最第N（即8）个的数字为81。
 * <p>
 * 输入描述：
 * 输入为以逗号分隔的描述3个int类型整数的字符串。
 * 输出描述：
 * 输出为这几个数字可拼成的数字从小到大排列位于第N（N为输入数字中最大的数字）位置的数字，如果输入的数字不在范围内或者有重复，则输出-1。
 * <p>
 * 示例1：
 * 输入
 * 1,4,8
 * 输出
 * 81
 */
public class 数字排列 {
    private static boolean contains(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(int[] nums, boolean[] used, Set<Integer> results, int number) {
        boolean allUsed = true;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                allUsed = false;
                break;
            }
        }
        if (allUsed) {
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                int n = nums[i];
                results.add(number * 10 + n);
                dfs(nums, used, results, number * 10 + n);
                if (n == 2) {
                    results.add(number * 10 + 5);
                } else if (n == 5) {
                    results.add(number * 10 + 2);
                    dfs(nums, used, results, number * 10 + 2);
                } else if (n == 6) {
                    results.add(number * 10 + 9);
                    dfs(nums, used, results, number * 10 + 9);
                } else if (n == 9) {
                    results.add(number * 10 + 6);
                    dfs(nums, used, results, number * 10 + 6);
                }
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String s = input.nextLine();
            String[] arr = s.split(",");
            if (arr.length != 3) {
                System.out.println("-1");
                continue;
            }
            boolean numvalid = true;
            int[] nums = new int[3];
            for (int i = 0; i < arr.length; i++) {
                try {
                    nums[i] = Integer.valueOf(arr[i]);
                } catch (Exception e) {
                    numvalid = false;
                    break;
                }
                if (nums[i] < 1 || nums[i] > 9) {
                    numvalid = false;
                    break;
                }
            }
            if (!numvalid) {
                System.out.println("-1");
                continue;
            }
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    numvalid = false;
                    break;
                }
            }
            if (!numvalid) {
                System.out.println("-1");
                continue;
            }
            if (contains(nums, 2) && contains(nums, 5)) {
                System.out.println("-1");
                continue;
            }
            if (contains(nums, 6) && contains(nums, 9)) {
                System.out.println("-1");
                continue;
            }
            Set<Integer> results = new HashSet<>();
            boolean[] used = new boolean[3];
            dfs(nums, used, results, 0);
            List<Integer> sorted = new ArrayList<Integer>(results);
            sorted.sort(Comparator.comparingInt((v) -> v));

            int toFind = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (toFind < nums[i]) {
                    toFind = nums[i];
                }
            }
            if (toFind > sorted.size()) {
                System.out.println(sorted.get(sorted.size() - 1));
            } else {
                System.out.println(sorted.get(toFind - 1));
            }
        }
    }
}
