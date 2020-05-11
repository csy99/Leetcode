package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Q021_Merge_Two_Sorted_Lists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    ListNode dum = new ListNode(-1);
    ListNode cur = dum;
    while (l1 != null || l2 != null) {
      int a = l1 == null ? Integer.MAX_VALUE : l1.val;
      int b = l2 == null ? Integer.MAX_VALUE : l2.val;
      if (a < b) {
        cur.next = l1;
        l1 = l1.next;  // won't throw nullPointerException, if l1 is null, a > b
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    return dum.next;
  }
}
