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
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            } 
            int v = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            ListNode cur = new ListNode(v);
            pre.next = cur;
            pre = cur;
        }
        if (carry > 0) {
            ListNode last = new ListNode(carry);
            pre.next = last;
        }
        return dummy.next;
    }
}
