package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by csy99 on 4/11/20.
 */
public class Q133_Clone_Graph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // mapping from original node to new clone node 
        HashMap<Node, Node> map = new HashMap();
        map.put(node, null);
        Queue<Node> q = new LinkedList();
        q.offer(node);
        
        // clone Node
        while (!q.isEmpty()) {
            Node cur = q.poll();
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            for (Node nei: cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, null);
                    q.offer(nei);
                }
            }
        }
        
        // build new graph
        for (Node ori: map.keySet()) {
            Node copy = map.get(ori);
            for (Node oriNei: ori.neighbors) 
                copy.neighbors.add(map.get(oriNei));
        }
        return map.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
