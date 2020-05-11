package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 */
public class Q002_Add_Two_Numbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode dum = new ListNode(-1);
    ListNode runner = dum;
    while (l1 != null || l2 != null) {
      int a = l1 == null ? 0 : l1.val;
      int b = l2 == null ? 0 : l2.val;
      int res = (a + b + carry)%10;
      carry = (a + b + carry)/10;
      ListNode tmp =  new ListNode(res);
      runner.next = tmp;
      runner = runner.next;
      if (l1 != null)
        l1 = l1.next;
      if (l2 != null)
        l2 = l2.next;
    }
    if (carry == 1) {
      ListNode tmp = new ListNode(1);
      runner.next = tmp;
    }
    return dum.next;
  }
}
