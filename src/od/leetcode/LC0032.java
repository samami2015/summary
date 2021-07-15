package od.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0032 {
    public static void main(String[] args) {
        LC0032 solution = new LC0032();
//        String s = "(()";
        String s = ")()())";
//        String s = "";
        int ans = solution.longestValidParentheses(s);
        System.out.println(ans);
    }
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
