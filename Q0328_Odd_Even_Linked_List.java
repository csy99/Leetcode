package Leetcode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q328_Odd_Even_Linked_List {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    // head will also serve as headOdd
    ListNode tailOdd = head;
    ListNode headEven = head.next;
    ListNode tailEven = head.next;
    while (tailEven != null && tailEven.next != null) {
      tailOdd.next = tailEven.next;
      tailOdd = tailOdd.next;
      tailEven.next = tailOdd.next;
      tailEven = tailEven.next;
    }
    tailOdd.next = headEven;
    return head;
  }
}
