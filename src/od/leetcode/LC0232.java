package od.leetcode;

public class LC0232 {
    public static void main(String[] args) {
        leetcode.MyQueue queue = new leetcode.MyQueue();
        queue.push(1);
//        System.out.println(queue.peek());
        queue.push(2);
        while (!queue.empty()) {
            System.out.println(queue.peek());
            queue.pop();
        }
        System.out.println(queue.empty());
    }

}
