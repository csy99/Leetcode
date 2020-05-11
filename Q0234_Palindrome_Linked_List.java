package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */
public class Q234_Palindrome_Linked_List {
  public boolean isPalindrome(ListNode head) {
    if (head == null)
      return true;
    ListNode slow = head;
    ListNode fast = head;
    // when the loop exits, slow will points to the last element in the first half of the linked list 
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // reverse the second half of the linked list
    ListNode h2 = slow.next;
    h2 = reverse(h2);
    ListNode p1 = head;
    ListNode p2 = h2;
    while (p2 != null) {  // the size of the second half <= that of the first half
      if (p1.val != p2.val)
        return false;
      p1 = p1.next;
      p2 = p2.next;
    }
    // recover the list
    h2 = reverse(h2);
    slow.next = h2;
    return true;
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
