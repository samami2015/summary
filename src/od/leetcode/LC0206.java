package od.leetcode;

public class LC0206 {
    public static void main(String[] args) {
        LC0206 solution = new LC0206();
        leetcode.ListNode head = new leetcode.ListNode(1);
        leetcode.ListNode node1 = new leetcode.ListNode(2);
        leetcode.ListNode node2 = new leetcode.ListNode(3);
        leetcode.ListNode node3 = new leetcode.ListNode(4);
        leetcode.ListNode node4 = new leetcode.ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        ListNode ans = solution.reverseList(head);
//        System.out.println(ans.val);

        leetcode.ListNode ans = solution.reverseN(head,3);
        System.out.println(ans.val);
    }

/*    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }*/

    leetcode.ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    leetcode.ListNode reverseN(leetcode.ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        leetcode.ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
}

