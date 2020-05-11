package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q143_Reorder_List {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null)
      return;
    // traverse and get the middle element (stored in slow pointer)
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // turn the second half into a new List
    ListNode h2 = slow.next;
    slow.next = null;
    h2 = reverse(h2);
    // merge two list one by one
    ListNode p1 = head;
    ListNode p2 = h2;
    while (p2 != null) {  // the size of second half <= that of first half
      ListNode nxt = p1.next;
      p1.next = p2;
      p2 = p2.next;
      p1.next.next = nxt;
      p1 = nxt;
    }
  }
  
  private ListNode reverse(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode nxt = head.next;
      head.next = newHead;
      newHead = head;
      head = nxt;
    }
    return newHead;
  }
}
