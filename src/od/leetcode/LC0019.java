package od.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0019 {
    public static void main(String[] args) {
        LC0019 solution = new LC0019();
       ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        int k = 2;
/*        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = null;
        int k = 1;*/

        ListNode ans = solution.removeNthFromEnd(node1, k);
        System.out.println(ans == null ? "" : ans.val);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        for(int i = 0;i<n;++i){
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
/*    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;
        //base case
        if (head.next == null && n == 1) {
            return null;
        }
        //链表大小
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
*//*        if (size == 1 && n == 1) {
            return null;
        }*//*
        int index = 0;
        cur = head;
        while (cur != null) {
            index++;
            cur = cur.next;
            if (index == size - n) {
                cur = cur.next;
            }
        }
        return head;
    }*/
}
