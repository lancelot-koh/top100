package day2;

import day1.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != fast) {
            if(slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }
}
