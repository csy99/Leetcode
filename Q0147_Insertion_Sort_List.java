package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre = dum.next;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val > pre.val) {
                pre = pre.next;
                cur = cur.next;
                continue;
            }
            ListNode nxt = cur.next;
            cur.next = null;
            pre.next = nxt;
            
            ListNode insertAfter = dum;
            while (insertAfter.next.val < cur.val)
                insertAfter = insertAfter.next;
            ListNode insertBefore = insertAfter.next;
            cur.next = insertBefore;
            insertAfter.next = cur;
            cur = nxt;
        }
        return dum.next;
    }
}
