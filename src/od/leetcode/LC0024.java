package od.leetcode;

public class LC0024 {
    public static void main(String[] args) {
        LC0024 soluton = new LC0024();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode ans = soluton.swapPairs(node1);
        System.out.println(ans.val);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;//2
        //原始链表中的其余节点的头节点是 newHead.next
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
