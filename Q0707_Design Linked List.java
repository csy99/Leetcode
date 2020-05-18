/**
 * Created by csy99 on 5/17/20.
 */
class MyLinkedList {
    ListNode dum;
    ListNode tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        dum = new ListNode(0);
        tail = dum;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        return traverse(index).val;
    }
    
    private ListNode traverse(int index) {
        ListNode cur = dum.next;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = dum.next;
        dum.next = node;
        size++;
        if (size == 1)
            tail = dum.next;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur = new ListNode(val);
        tail.next = cur;
        tail = cur;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        ListNode pre = traverse(index-1);
        ListNode cur = new ListNode(val);
        cur.next = pre.next;
        pre.next = cur;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        if (index == 0) {
            if (size == 1) {  // only one node in list
                dum.next = null;
                tail = dum;
            } else  // delete head
                dum.next = dum.next.next;
            size--;
            return;
        }
        if (index == size - 1)  // delete tail
            tail = traverse(size-2);
        ListNode pre = traverse(index-1);
        pre.next = pre.next.next;
        size--;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int v) {
        val = v;
        next = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
