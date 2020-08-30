package Leetcode;

/**
 * Created by csy99 on 8/30/20.
 */
public class Q430_Flatten_a_Multilevel_Doubly_Linked_List {
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    // recursion 1
    public Node flatten(Node head) {
        if (head == null) return null;
        return flattenHelper(head)[0];
    }
    
    public Node[] flattenHelper(Node head) {
        Node[] res = new Node[] {head, null};
        Node tail = null;
        Node cur = head;
        while (cur != null) {
            tail = cur;
            if (cur.child == null) {
                cur = cur.next;
                continue;
            }
            Node nxt = cur.next;
            cur.next = null;
            if (nxt != null)
                nxt.prev = null;
            Node chd = cur.child;
            cur.child = null;
            Node[] childLevel = flattenHelper(chd);
            cur.next = childLevel[0];
            childLevel[0].prev = cur;
            childLevel[1].next = nxt;
            if (nxt != null)
                nxt.prev = childLevel[1];
            tail = childLevel[1];  // don't forget to update tail
            cur = nxt;
        }
        res[1] = tail;
        return res;
    }
  
    // recursion 2
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node nxt = cur.next;
                Node chd = flatten(cur.child);
                cur.next = chd;
                chd.prev = cur;
                cur.child = null;
                if (nxt != null) {
                    while (chd.next != null)
                        chd = chd.next;
                    chd.next = nxt;
                    nxt.prev = chd;
                }
                cur = nxt;
            }
            if (cur != null)
                cur = cur.next;
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
