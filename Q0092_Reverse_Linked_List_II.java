package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 */
public class Q092_Reverse_Linked_List_II {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) 
      return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode preM = dummy;
    ListNode mNode = head;
    ListNode nNode = head;
    for (int i = 1; i < n; i++) {
      if (i < m) {
        preM = mNode;
        mNode = mNode.next;
      }
      nNode = nNode.next;
    }
    while (mNode != nNode) {
      preM.next = mNode.next;
      mNode.next = nNode.next;
      nNode.next = mNode;
      mNode = preM.next;
    }
    return dummy.next;
  }
  
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode preM = dum;
        for (int i = 0; i < m-1; i++)
            preM = preM.next;
        ListNode start = preM.next;
        ListNode cur = start;
        preM.next = null;
        ListNode pre = null;
        ListNode post = null;
        for (int i = 0; i <= n-m; i++) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        preM.next = pre;
        start.next = post;
        return dum.next;
    }
}
