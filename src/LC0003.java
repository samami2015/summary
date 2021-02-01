import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LC0003 {
    public int lengthOfLongestSubString(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC0003 solution = new LC0003();
        String s1 = "abcabcbb";
        int len = solution.lengthOfLongestSubString(s1);
        System.out.println(len);
        String s2 = "bbbbb";
        len = solution.lengthOfLongestSubString(s2);
        System.out.println(len);

    }
}
