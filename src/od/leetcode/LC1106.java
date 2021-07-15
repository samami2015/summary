package od.leetcode;

import java.util.Stack;

public class LC1106 {
    public static void main(String[] args) {
        LC1106 solution = new LC1106();
//        String expression = "!(f)";
//        String expression = "|(f,t)";
        String expression = "&(t,f)";
        solution.parseBoolExpr(expression);
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> worker = new Stack<>();
        //expression = "!(f)"
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            Stack<Character> operTemp = new Stack<>();
            if (currentChar == ',') {
                continue;
            }
            if (currentChar != ')') {
                worker.push(currentChar);
            } else {
                //worker : &(tf
                while (worker.peek() != '(') {
                    //压入f、t
                    operTemp.push(worker.pop());
                }
                //此时弹出(
                worker.pop();
                //此时弹出&
                char oper = worker.pop();
                Character blockResult = blockExpr(operTemp, oper);
                if (blockResult == null) {
                    System.out.println("运算符输入有误,结果不可信");
                    return false;
                }
                worker.push(blockResult);
            }
        }
        return worker.pop() == 't';
    }

    public Character blockExpr(Stack<Character> operStack, char oper) {
        if (oper == '!') {
            return operStack.pop() == 't' ? 'f' : 't';
        }
        if (oper == '&') {
            while (!operStack.isEmpty()) {
                if (operStack.pop() == 'f') {
                    return 'f';
                }
            }
            return 't';
        }
        if (oper == '|') {
            while (!operStack.isEmpty()) {
                if (operStack.pop() == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return null;
    }
}
