package day1;

import java.util.List;
import java.util.TreeMap;

public class MergekSortedLists {
    public ListNode mergeKSortedLists(ListNode[] lists) {
        TreeMap<Integer, ListNode>  map = new TreeMap<>();
        for(int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                int val = lists[i].val;
                if (map.containsKey(val)) {
                    ListNode node = new ListNode(val, map.get(val));
                    map.put(val, node);
                } else {
                    map.put(val, new ListNode(val));
                }
                lists[i] = lists[i].next;
            }
        }

        ListNode dummy = new ListNode();
        for(ListNode node: map.values()) {
            dummy.next = node;
            ListNode curr = node;
            while (curr.next != null) {
                curr = curr.next;
            }
            dummy = curr;

        }

        return map.isEmpty() ? null : map.get(map.firstKey());

    }

}
