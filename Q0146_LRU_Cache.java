package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 4/19/20.
 */
public class Q146_LRU_Cache {
    private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    
    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode cur = cache.get(key);
        if (cur == null)
            return -1;
        moveToHead(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        DLinkedNode cur = cache.get(key);
        if (cur != null) {
            cur.val = value;
            moveToHead(cur);
            return;
        }
        
        if (count >= capacity) {
            DLinkedNode last = popTail();
            cache.remove(last.key);
            count--;
        }
        
        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.val = value;
        cache.put(key, newNode);
        addNode(newNode);
        count++;
    }
    
    
    class DLinkedNode {
      int key;
      int val;
      DLinkedNode pre;
      DLinkedNode post;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
      node.pre = head;
      node.post = head.post;

      head.post.pre = node;
      head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
      DLinkedNode pre = node.pre;
      DLinkedNode post = node.post;

      pre.post = post;
      post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
      this.removeNode(node);
      this.addNode(node);
    }

    // pop the current tail. 
    private DLinkedNode popTail(){
      DLinkedNode res = tail.pre;
      this.removeNode(res);
      return res;
    }
}


