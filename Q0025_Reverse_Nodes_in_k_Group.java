package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 */
public class Q025_Reverse_Nodes_in_k_Group {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k < 2)
      return head;
    ListNode dum = new ListNode(0);
    dum.next = head;
    ListNode prev = dum;
    while (prev != null) {
      prev = reverseK(prev, k);
    }
    return dum.next;
  }
  
  // return the last element for reversed sub linked list
  public ListNode reverseK(ListNode prev, int k) {
    ListNode nextStart = prev;
    for (int i = 0; i < k+1; i++) {
      nextStart = nextStart.next;
      if (i != k && nextStart == null)  // less than k elements
        return null;
    }
    ListNode tail = prev.next;  // the tail after reversing
    ListNode cur = prev.next.next;
    while (cur != nextStart) {
      ListNode nxt = cur.next;
      cur.next = prev.next;
      prev.next = cur;
      tail.next = nxt;
      cur = nxt;
    }
    return tail;
  }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        int cnt = 0;
        ListNode pre = dum;
        ListNode cur = pre;
        while (cur != null) {
            while (cnt < k) {
                cur = cur.next;
                if (cur == null && cnt < k)  // the last few fail to form a group
                    return dum.next;
                cnt++;
            }
            ListNode nxtStart = cur.next;
            cur.next = null;
            ListNode h = pre.next;
            pre.next = null;
            ListNode[] part = reverse(h);
            pre.next = part[0];
            part[1].next = nxtStart;
            pre = part[1];
            cur = part[1];
            cnt = 0;
        }
        return dum.next;
    }
    
    private ListNode[] reverse(ListNode head) {
        ListNode h2 = null;
        ListNode t2 = head;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = h2;
            h2 = head;
            head = nxt;
        }
        return new ListNode[] {h2, t2};
    }
}
