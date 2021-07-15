package od.leetcode;

public class LC0005 {
    public static void main(String[] args) {
        LC0005 solution = new LC0005();
        String s = "babad";
        String ans = solution.longestPalindrome(s);
        System.out.println(ans);
    }

    public int expandAroundCenter(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            --l;
            ++r;
        }
        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //计算以 s[i] 为中心的回文串的长度
            int lengh1 = expandAroundCenter(s, i, i);
            //计算以 s[i] 和 s[i+1] 为中心的回文串的长度
            int lengh2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(lengh1, lengh2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

 /*   String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r - l - 1);
    }*/

}
