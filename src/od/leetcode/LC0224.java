package od.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0224 {
    public static void main(String[] args) {
//        String s = "458";
//
//        int n = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            n = 10 * n + (c - '0');
//        }
//
//        System.out.println(n);
//        String s = "1-12+3";
        String s = "2-3*4+5";
        LC0224 solution = new LC0224();
        int ans = solution.calculate(s);
        System.out.println(ans);
    }

    int calculate(String s) {
        Deque<Integer> stk = new LinkedList<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            //遇到左括号开始递归计算 num
            if(c=='(') {
            }
            // 如果不是数字，就是遇到了下一个符号，之前的数字和符号就要存进栈中
            if ((!Character.isDigit(c) && c!=' ')|| i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                    case '*':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(pre*num);
                        break;
                    case '/':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(pre/num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }
        // 将栈中所有结果求和就是答案
        int res = 0;
        while (!stk.isEmpty()){
            res += stk.peek();
            stk.pop();
        }
        return res;
    }
}
