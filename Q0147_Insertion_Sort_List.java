package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q147_Insertion_Sort_List {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode dum = new ListNode(0);
    dum.next = head;
    ListNode cur = head;
    ListNode pre = dum;
    ListNode tmp = null;
    while (cur != null && cur.next != null) {
      if (cur.val <= cur.next.val) {
        cur = cur.next;
        continue;
      }
      tmp = cur.next;
      cur.next = tmp.next;
      tmp.next = null;
        
      pre = dum;
      while (pre.next.val < tmp.val)
        pre = pre.next;
      tmp.next = pre.next;
      pre.next = tmp;
    }
    return dum.next;
  }
}
