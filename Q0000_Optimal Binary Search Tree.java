/**
 * Created by csy99 on 10/26/21.
 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 */
class Node {
    int idx;
    int val;
    int freq;
        
    public Node(int i, int v, int f) {
        idx = i;
        val = v;
        freq = f;
    }
    
    public int compareTo(Node o) {
        return Integer.compare(val, o.val);
    }
}
public class Main{
    static int n;
    public static int optimalBST(int[] val, int[] freq) {
        n = val.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, val[i], freq[i]);
            nodes[i] = node;
        }
        Arrays.sort(nodes);
        return optCost(nodes, 0, n-1);
    }
    
    private static int sum(Node[] nodes, int l, int r) {
        int s = 0;
        for (int i = l; i <= r; i++)
            s += nodes[i].freq;
        return s;
    }
    
    private static int optCost(Node[] nodes, int l, int r) {
        if (r < l) return 0;
        if (l == r) return nodes[l].freq;
        int wholeTree = sum(nodes, l, r);
        int res = Integer.MAX_VALUE;
        for (int root = l; root <= r; root++) {
            int cost = optCost(nodes, l, root-1) + optCost(nodes, root+1, r);
            if (cost < res)
                res = cost;
        }
        return wholeTree + res;
    }
}
