package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q082_Remove_Duplicates_from_Sorted_List_II {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dum = new ListNode(0);
    dum.next = head;
    ListNode cur = dum;
    while (cur.next != null) {
      ListNode n1 = cur.next;
      ListNode n2 = cur.next.next;
      if (n2 == null || n1.val != n2.val) {
        cur = cur.next;
      } else {
        while (n2 != null && n2.val == n1.val) {
          n2 = n2.next;
        }
        cur.next = n2;
      }
    }
    return dum.next;
  }
}
