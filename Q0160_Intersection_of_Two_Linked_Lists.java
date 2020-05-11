package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q160_Intersection_of_Two_Linked_Lists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int sizeA = size(headA);
    int sizeB = size(headB);
    ListNode pA = headA;
    ListNode pB = headB;
    if (sizeA > sizeB) {
      for (int i = 0; i < sizeA - sizeB; i++)
        pA = pA.next;
    } else if (sizeA < sizeB) {
      for (int i = 0; i < sizeB - sizeA; i++)
        pB = pB.next;
    }
    while (pA != null) {
      if (pA == pB)
        return pA;
      pA = pA.next;
      pB = pB.next;
    }
    return null;
  }
  
  private int size(ListNode head) {
    int size = 0;
    ListNode a = head;
    while (a != null) {
      size++;
      a = a.next;
    }
    return size;
  }
}
