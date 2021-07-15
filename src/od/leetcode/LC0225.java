package od.leetcode;

public class LC0225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
//        System.out.println(stack.top());
        stack.push(2);
//        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }
}
