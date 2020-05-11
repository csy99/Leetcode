package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q148_Sort_List {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    
    int len = 1;
    ListNode cur = head;
    while (cur.next != null) {
      ++len;
      cur = cur.next;
    }
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode l;
    ListNode r;
    ListNode tail;
    for (int n = 1; n < len; n <<= 1) {      
      cur = dummy.next; // partial sorted head
      tail = dummy;
      while (cur != null) {
        l = cur;
        r = split(l, n);
        cur = split(r, n);
        ListNode[] merged = merge(l, r);
        tail.next = merged[0];
        tail = merged[1];
      }
    }      
    return dummy.next;
  }
  
  // Splits the list into two parts, first n element and the rest. Returns the head of the rest.
  private ListNode split(ListNode head, int n) {    
    while (--n > 0 && head != null)
      head = head.next;
    ListNode rest = head == null ? null : head.next;
    if (head != null) 
      head.next = null;
    return rest;
  }
  
  // Merges two lists, returns the head and tail of the merged list.
  private ListNode[] merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        tail.next = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        l2 = l2.next;
      }
      tail = tail.next;
    }
    tail.next = l1 == null ? l2 : l1;
    while (tail.next != null) 
      tail = tail.next;
    ListNode[] res = new ListNode[2];
    res[0] = dummy.next;
    res[1] = tail;
    return res;
  }
}
