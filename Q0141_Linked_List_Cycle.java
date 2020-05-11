package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q0141_Linked_List_Cycle {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null)  // no cycle for sure
      return false; 
    ListNode fast = head.next;
    ListNode slow = head;
    while (slow != fast) {
      if (fast == null || fast.next == null)
        return false;
      fast = fast.next.next;
      slow = slow.next;
    }
    return true;
  }
}
