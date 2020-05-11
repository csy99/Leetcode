package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class Q142_Linked_List_Cycle_II {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null)
      return null;
    ListNode slow = head;
    ListNode fast = head;
    boolean cycle = false;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        cycle = true;
        break;
      }
    }
    if (!cycle) return null;
    fast = head;
    while (slow != fast) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
