/**
 * Created by csy99 on 9/20/20.
 
 Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.
 */
class Solution {
	public Node insert(Node head, int insertVal) {
		Node toInsert = new Node();
		if (head == null) {
			toInsert.val = insertVal;
			toInsert.next = toInsert;
			return toInsert;
		}
		Node max = head;
		while (max.next != head && max.val <= max.next.val) 
			max = max.next;
		Node min = max.next;
		if (insertVal >= max.val || insertVal <= min.val) {
			toInsert.val = insertVal;
			toInsert.next = min;
			max.next = toInsert;
			return head;
		}
		Node cur = min;
		while (cur.next.val < insertVal) 
			cur = cur.next;
		Node nxt = cur.next;
		cur.next = toInsert;
		toInsert.next = nxt;
		return head;
	}
}
