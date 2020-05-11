package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * https://leetcode.com/problems/partition-list/
 */
public class Q086_Partition_List {
  public ListNode partition(ListNode head, int x) {
    ListNode h1 = new ListNode(0);
    ListNode t1 = h1;
    ListNode h2 = new ListNode(0);
    ListNode t2 = h2;
    
    while (head != null) {
      ListNode next = head.next;
      if (head.val < x) {
        t1.next = head;
        t1 = t1.next;
        t1.next = null;
      } else {
        t2.next = head;
        t2 = t2.next;
        t2.next = null;
      } 
      head = next;
    }
    // concat all lists
    ListNode newHead = new ListNode(0);
    ListNode newTail = newHead;
    if (h1.next != null) {
      newHead.next = h1.next;
      newTail = t1;
    } 
    if (h2.next != null) {
      newTail.next = h2.next;
      newTail = t2;
    }
    return newHead.next;
  }
}
