package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HJ054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            List<String> list = new ArrayList<>();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (isNum(c)) {
                    int start = i;
                    if (i == str.length() - 1) {
                        i++;
                    } else {
                        while (isNum(str.charAt(++i))) ;
                    }
                    list.add(str.substring(start, i));
                    i--;
                } else if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    while (stack.peek() != '(' && stack.peek() != '[' && stack.peek() != '{') {
                        list.add(String.valueOf(stack.pop()));
                    }
                    stack.pop();
                } else if (c == '-') {
                    if ((i != 0 && (isNum(str.charAt(i - 1)) && isNum(str.charAt(i + 1)))) && (str.charAt(i - 1) == ')'
                            || str.charAt(i - 1) == ']' || str.charAt(i - 1) == '}') || (str.charAt(i + 1) == ')' || str.charAt(i + 1) == ']' || str.charAt(i + 1) == '}')) {
                        while (!greaterThan(c, stack)) {
                            list.add(String.valueOf(stack.pop()));
                        }
                        stack.push(c);
                    } else {
                        int start = i;
                        while (isNum(str.charAt(++i))) {
                        }
                        list.add(str.substring(start, i));
                        i--;
                    }
                } else if (c == '+') {
                    while (!greaterThan(c, stack)) {
                        list.add(String.valueOf(stack.pop()));
                    }
                    stack.push(c);
                }
            }
            while (!stack.isEmpty()) {
                list.add(String.valueOf(stack.pop()));
            }
            System.out.println(calculate(list));
        }
    }

    private static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int n1;
            int n2;
            switch (s) {
                case "*":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n1 * n2);
                    break;
                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;
                case "+":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n1 + n2);
                    break;
                case "-":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2-n1);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private static boolean greaterThan(char c, Stack<Character> stack) {
        if (stack.isEmpty()) {
            return true;
        } else {
            char c1 = stack.peek();
            if (c == '*' || c == '/') {
                return !(c1 == '*' || c1 == '/');
            } else {
                return c1 == '(' || c1 == '[' || c1 == '{';
            }
        }
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
