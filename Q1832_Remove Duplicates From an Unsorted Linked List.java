/**
 * Created by csy99 on 9/15/21.
 */
class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> counts = new HashMap();
        ListNode cur = head;
        while (cur != null) {
            counts.put(cur.val, counts.getOrDefault(cur.val,0)+1);
            cur = cur.next;
        }
        ListNode dum = new ListNode(0);
        dum.next = head;
        cur = head;
        ListNode pre = dum;
        while (cur != null) {
            int cnt = counts.get(cur.val);
            if (cnt > 1) 
                pre.next = cur.next; 
            else 
                pre = pre.next;
            cur = cur.next;
        }
        return dum.next;
    }
}
