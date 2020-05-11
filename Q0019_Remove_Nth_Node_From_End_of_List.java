package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q019_Remove_Nth_Node_From_End_of_List {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    ListNode cur = dummy;
    // when the loop exits, fast points to the tail
    // cur points to the predecessor of the node to be deleted
    while (fast.next != null) {
      fast = fast.next;
      cur = cur.next;
    }
    cur.next = cur.next.next;
    return dummy.next;
  }
}
