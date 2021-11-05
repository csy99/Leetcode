/**
 * Created by csy99 on 11/5/21.
 */
class BrowserHistory {
    Node head;
    Node tail;
    Node cur;
    public BrowserHistory(String homepage) {
        head = new Node("");
        tail = new Node("");
        head.next = tail;
        tail.prev = head;
        cur = head;
        visit(homepage);
    }
    
    public void visit(String url) {
        Node last = cur;
        cur = new Node(url);
        cur.next = tail;
        tail.prev = cur;
        last.next = cur;
        cur.prev = last;
    }
    
    public String back(int steps) {
        for (int s = 0; s < steps; s++) {
            if (cur.prev == head) break;
            cur = cur.prev;
        }
        return cur.url;
    }
    
    public String forward(int steps) {
        for (int s = 0; s < steps; s++) {
            if (cur.next == tail) break;
            cur = cur.next;
        }
        return cur.url;
    }
}

class Node {
    String url;
    Node next;
    Node prev;
    
    public Node (String u) {
        url = u;
        next = null;
        prev = null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
 
