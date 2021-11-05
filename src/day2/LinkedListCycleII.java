package day2;

import day1.ListNode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = getInersect(head);
        if(node == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = node;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private ListNode getInersect(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;

       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast) {
               return slow;
           }
       }
       return null;
    }
}
