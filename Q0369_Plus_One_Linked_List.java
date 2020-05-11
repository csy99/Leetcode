package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * 
 * Given a non-negative number represented as a singly linked list of digits,
 * plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Example:
 * Input: 1->2->3
 * Output: 1->2->4
 */

public class Q369_Plus_One_Linked_List {
    // two pointer
    public ListNode plusOne(ListNode head) {
      ListNode dum = new ListNode(0);
      dum.next = head;
      ListNode prev = dum;
      ListNode runner = dum;
      // prev will be the last number < 9
      while (runner.next != null) {
        runner = runner.next;
        if (runner.val < 9)
          prev = runner;
      }
      prev.val++;
      prev = prev.next;
      while (prev != null) {
        prev.val = 0;
        prev = prev.next;
      }
      if (dum.val == 1)  // all numbers in the list are 9
        return dum;
      return dum.next;
    }
    
    // reversing
    public ListNode plusOne(ListNode head) {
      ListNode newHead = reverse(head);
      ListNode cur = newHead;
      while (cur != null) {
        if (cur.val < 9) {
          cur.val++;
          break;
        }
        else {
          cur.val = 0;
          if (cur.next == null) {  // all 9s in the list
            ListNode carry = new ListNode(1);
            cur.next = carry;
            break;
          }
        }
        cur = cur.next;
      }
      return reverse(newHead);
    }

    // reverse the whole list
    private ListNode reverse(ListNode head) {
      ListNode newHead = null;
      while (head != null) {
        ListNode nextNode = head.next;
        head.next = newHead;
        newHead = head;
        head = nextNode;
      }
      return newHead;
    }
}
