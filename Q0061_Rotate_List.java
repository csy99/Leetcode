package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q061_Rotate_List {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    int size = size(head);
    k = k % size;
    if (k == 0) return head;
    ListNode dum = new ListNode(0);
    dum.next = head;
    ListNode pre = dum;  // points to the last element in the first part
    for (int i = 0; i < size - k; i++) {
      pre = pre.next;
    }
    ListNode h2 = pre.next;
    pre.next = null;
    // traverse through the second part to get the tail
    ListNode t2 = h2;
    while (t2.next != null)
      t2 = t2.next;
    dum.next = h2;
    t2.next = head;
    return dum.next;
  }
  
  private int size(ListNode head) {
    ListNode runner = head;
    int cnt = 0;
    while (runner != null) {
      cnt++;
      runner = runner.next;
    }
    return cnt;
  }
}
