package Leetcode;

/**
 * Created by csy99 on 3/23/2021.
 */
class AllOne {
    Node head;
    Node tail;
    Map<String, Node> map;
    
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    private Node addAfter(Node cur, int val) {
        Node neo = new Node(val);
        Node nxt = cur.next;
        cur.next = neo;
        neo.prev = cur;
        neo.next = nxt;
        nxt.prev = neo;
        return neo;
    }
    
    // return the neighbors of the node that should be delete
    private Node[] deleteNode(Node cur) {
        Node pre = cur.prev;
        Node nxt = cur.next;
        cur.prev = null;
        cur.next = null;
        pre.next = nxt;
        nxt.prev = pre;
        return new Node[] {pre, nxt};
    }
    
    private void printMap() {
        for (String k: map.keySet()) {
            System.out.println("key:"+k+"; val:"+map.get(k).val);
        }
        System.out.println();
    }
    
    private void printList() {
        Node cur = head.next;
        while (cur != tail) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
        System.out.println();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node cur = map.getOrDefault(key, null);
        int val = 0;
        if (cur != null) {
            val = cur.val;
            cur.set.remove(key);
            if (cur.set.size() == 0) 
                cur = deleteNode(cur)[0];
        } else {
            cur = head;
        }
        if (cur.next.val != val+1)
            addAfter(cur, val+1);
        Node neo = cur.next;
        neo.set.add(key);
        map.put(key, neo);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node cur = map.getOrDefault(key, null);
        if (cur == null) return;
        int val = cur.val;
        cur.set.remove(key);
        if (cur.set.size() == 0)
            cur = deleteNode(cur)[1];
        if (val == 1) {  // don't forget
            map.remove(key);
            return;
        }
        if (cur.prev.val != val-1)
            addAfter(cur.prev, val-1);
        Node neo = cur.prev;
        neo.set.add(key);
        map.put(key, neo);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head.next == tail)
            return "";
        Set<String> set = tail.prev.set;
        Iterator<String> iter = set.iterator();
        return iter.next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail)
            return "";
        Set<String> set = head.next.set;
        Iterator<String> iter = set.iterator();
        return iter.next();
    }
}

class Node {
    int val;
    Set<String> set;
    Node prev;
    Node next;
    
    public Node() {
        val = 0;
        set = new HashSet();
        prev = null;
        next = null;
    }
    
    public Node(int v) {
        this();
        val = v;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
