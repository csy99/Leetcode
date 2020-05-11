package Leetcode;

import Leetcode.Util.ListNode;

import java.util.Random;

/**
 * Created by csy99 on 4/12/20.
 */
public class Q382_Linked_List_Random_Node {
    private ListNode root;
    private Random rand;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        root = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = root;
        int res = root.val;
        for (int i = 1; cur.next != null; i++) {
            cur = cur.next;
            if (rand.nextInt(i+1) == 0)
                res = cur.val;
        }
        return res;
    }
}
