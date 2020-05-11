package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 */
public class Q0024_Swap_Nodes_in_Pairs {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      swap2(cur);
      cur = cur.next.next;
    }
    return dummy.next;
  }
  
  private void swap2(ListNode head) {
    ListNode n1 = head.next;
    ListNode n2 = head.next.next;
    head.next = n2;
    n1.next = n2.next;
    n2.next = n1;
  }
}
