package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * https://leetcode.com/problems/partition-list/
 */
public class Q086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode dum1 = new ListNode(0);
        ListNode dum2 = new ListNode(0);
        ListNode t1 = dum1;
        ListNode t2 = dum2;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = null;
            if (head.val < x) {
                t1.next = head;
                t1 = head;
            } else {
                t2.next = head;
                t2 = head;
            }
            head = nxt;
        }
        if (dum1.next == null)  // no value smaller than x
            return dum2.next;
        t1.next = dum2.next;
        return dum1.next;
    }
}
