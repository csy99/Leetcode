package Leetcode;

/**
 * Created by csy99 on 4/12/20.
 */
public class Q138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        
        // link random pointer
        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            if (cur.random != null)
                copy.random = cur.random.next;
            cur = cur.next.next;
        }
        
        // link next pointer
        cur = head;
        Node dummy = new Node(0);
        Node copyPrev = dummy; 
        while (cur != null) {
            copyPrev.next = cur.next;
            cur.next = cur.next.next;
            copyPrev = copyPrev.next;
            cur = cur.next;
        }
        return dummy.next;    
    }
}
