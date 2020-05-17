package Leetcode;

/**
 * Created by csy99 on 5/17/20.
 */
public class Q445_Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (s1.size() > 0 || s2.size() > 0) {
            int a = s1.size() > 0 ? s1.pop() : 0;
            int b = s2.size() > 0 ? s2.pop() : 0;
            ListNode curBit = new ListNode((a + b + carry) % 10);
            curBit.next = head;
            head = curBit;
            carry = (a + b + carry) / 10;
        }
        if (carry > 0) {
            ListNode msb = new ListNode(1);
            msb.next = head;
            head = msb;
        }
        return head;
    }
}
