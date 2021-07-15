package od.leetcode;

public class LC0002 {

    public static void main(String[] args) {
        LC0002 solution = new LC0002();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode nodeA = new ListNode(5);
        ListNode nodeB = new ListNode(6);
        ListNode nodeC = new ListNode(4);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = null;

        ListNode ans = solution.addTwoNumbers(node1,nodeA);
        System.out.println(ans);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //如果当前两个链表处相应位置的数字为 n1,n2n1,n2，进位值为carry，则它们的和为 n1+n2+carry
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
