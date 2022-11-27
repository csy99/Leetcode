/**
 * Created by csy99 on 11/27/22.
 */
// monoq
// time: O(n), space: O(n)
class Solution {
    public ListNode removeNodes(ListNode head) {
        List<Integer> monoq = new ArrayList();
        ListNode cur = head;
        while (cur != null) {
            while (monoq.size() > 0 && monoq.get(monoq.size()-1) < cur.val)
                monoq.remove(monoq.size()-1);
            monoq.add(cur.val);
                
            cur = cur.next;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        cur = head;
        while (!monoq.isEmpty()) {
            int target = monoq.remove(0);
            while (cur.val != target)
                cur = cur.next;
            tail.next = cur;
            tail = tail.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}

// recursion
// time: O(n), space: O(n)
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }
}
