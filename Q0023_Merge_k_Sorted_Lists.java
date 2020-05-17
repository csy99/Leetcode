package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * Merge k sorted linked lists
 * and return it as one sorted list. Analyze and describe its complexity.
 */
public class Q023_Merge_k_Sorted_Lists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0)
      return null;
    int interval = 1;
    while (interval < lists.length) {
      for (int i = 0; i < lists.length - interval; i += interval*2) {
        lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
      }
      interval *= 2;
    }
    return lists[0];    
  }
    
  // leetcode 21  
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    ListNode dum = new ListNode(-1);
    ListNode cur = dum;
    while (l1 != null && l2 != null) {
      int a = l1 == null ? Integer.MAX_VALUE : l1.val;
      int b = l2 == null ? Integer.MAX_VALUE : l2.val;
      if (a < b) {
        cur.next = l1;
        l1 = l1.next;  // won't throw nullPointerException, if l1 is null, a > b
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 != null)
      cur.next = l1;
    if (l2 != null)
      cur.next = l2;
    return dum.next;
  }  
}

// priority queue
// time: O(n*log k), space: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode dum = new ListNode(0);
        ListNode pre = dum;
        PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.listNode.val - b.listNode.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            Node a = new Node(lists[i], i);
            lists[i] = lists[i].next;
            pq.add(a);
        }
        while (pq.size() > 0) {
            Node cur = pq.poll();
            pre.next = cur.listNode;
            pre = cur.listNode;
            int idx = cur.idx;
            if (lists[idx] != null) {
                ListNode toBeAdded = lists[idx];
                lists[idx] = lists[idx].next;
                Node tmp = new Node(toBeAdded, idx);
                pq.add(tmp);
            }
        }
        return dum.next;
    }
    
}

class Node {
    ListNode listNode;
    int idx;
    
    public Node(ListNode c, int i) {
        listNode = c;
        idx = i;
    }
}
