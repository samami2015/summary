package od.leetcode;

public class LC0160 {
    public static void main(String[] args) {
        LC0160 solution = new LC0160();
        //listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode nodeA = new ListNode(5);
        ListNode nodeB = new ListNode(0);
        ListNode nodeC = new ListNode(1);
        ListNode nodeD = new ListNode(8);
        ListNode nodeE = new ListNode(4);
        ListNode nodeF = new ListNode(5);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = null;

        ListNode ans = solution.getIntersectionNode(node1,nodeA);
        System.out.println(ans);

    }
/*    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

}
