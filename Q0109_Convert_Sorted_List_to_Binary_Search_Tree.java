package Leetcode;

import Leetcode.Util.ListNode;
import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/6/20.
 */
public class Q109_Convert_Sorted_List_to_Binary_Search_Tree {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    ListNode mid = findMid(head);
    TreeNode root = new TreeNode(mid.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(mid.next);
    return root;
  }
  
  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;
    return slow;
  }
}
