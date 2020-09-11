package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * Merge k sorted linked lists
 * and return it as one sorted list. Analyze and describe its complexity.
 */
public class Q023_Merge_k_Sorted_Lists {

// extension for merging 2 lists
// time: O(n*log k), space: O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        int interval = 1;
        while (interval < n) {
            for (int i = 0; i < n-interval; i+=interval*2) 
                lists[i] = merge2Lists(lists[i], lists[i+interval]);
            interval *= 2;
        }
        return lists[0];
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(2);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;    
            } else {
                tail.next = l2;
                l2 = l2.next;                
            }
            tail = tail.next;
        }
        if (l1 != null)
            tail.next = l1;
        if (l2 != null)
            tail.next = l2;
        return dummy.next;
    }
}

// priority queue
// time: O(n*log k), space: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        int n = lists.length;
        for (int i = 0; i < n; i++) {
            if (lists[i] == null) continue;
            Entry entry = new Entry(lists[i], i);
            lists[i] = lists[i].next;
            pq.offer(entry);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (pq.size() > 0) {
            Entry cur = pq.poll();
            tail.next = cur.node;
            tail = cur.node;
            if (lists[cur.idx] != null) {
                pq.offer(new Entry(lists[cur.idx], cur.idx));
                lists[cur.idx] = lists[cur.idx].next;
            }
        }
        return dummy.next;
    }
}

class Entry implements Comparable<Entry>{
    ListNode node;
    int idx;
    
    public Entry(ListNode nd, int i) {
        node = nd;
        idx = i;
    }
    
    public int compareTo(Entry e2) {
        return Integer.compare(node.val, e2.node.val);
    }
}
