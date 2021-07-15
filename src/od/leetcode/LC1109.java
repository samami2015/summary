package od.leetcode;

import java.util.Arrays;

public class LC1109 {
    public static void main(String[] args) {
        LC1109 solution = new LC1109();
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        int[] ans = solution.corpFlightBookings(bookings,n);
        System.out.println(Arrays.toString(ans));
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counter = new int[n];
        for (int[] booking : bookings) {
            //在 i 站增加 k 人即 counters[i-1] += k
            counter[booking[0] - 1] += booking[2];
            //在 j+1 站减少 k 人即 counters[j] -= k
            if (booking[1] < n) {
                counter[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            counter[i] += counter[i - 1];
        }
        return counter;
    }
}
