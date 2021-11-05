package day2;

import day1.ListNode;

public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null? l2 : l1.next;
            l2 = l2 == null? l1 : l2.next;
        }
        return l1;
    }

}
