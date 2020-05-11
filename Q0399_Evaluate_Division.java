package Leetcode;

/**
 * Created by csy99 on 4/11/10.
 */
public class Q399_Evaluate_Division {
    // Graph + DFS
    // time: O(e * q)
    HashMap<String, HashMap<String, Double>> g;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        g = new HashMap();
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> vars = equations.get(i);
            String first = vars.get(0);
            String second = vars.get(1);
            double val = values[i];
            g.computeIfAbsent(first, l -> new HashMap<String, Double>()).put(second, val);
            g.computeIfAbsent(second, l -> new HashMap<String, Double>()).put(first, 1.0 / val);
        }
        
        int idx = 0;
        for (List<String> qry: queries) {
            String first = qry.get(0);
            String second = qry.get(1);
            if (!g.containsKey(first) || !g.containsKey(second)) {
                res[idx++] = -1;
            } else {
                res[idx++] = divide(first, second, new HashSet<String>() );
            }
        }
        return res;
    }
    
    private double divide(String x, String y, HashSet<String> visited) {
        if (x.equals(y)) return 1;
        if (!g.containsKey(x)) return -1;
        visited.add(x);
        for (String nxt: g.get(x).keySet()) {
            if (visited.contains(nxt)) continue;
            visited.add(nxt);
            double quotient = divide(nxt, y, visited);
            if (quotient > 0)
                return quotient * g.get(x).get(nxt);
        }
        return -1;
    }
    
    // Union Find
    // time: O(e + q)
    class Node {
        String parent;
        double ratio;
        public Node(String parent, double ratio) {
            this.parent = parent;
            this.ratio = ratio;
        }
    }
    
    private Map<String, Node> parents = new HashMap();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            union(eq.get(0), eq.get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Node rx = find(queries.get(i).get(0));
            Node ry = find(queries.get(i).get(1));
            if (rx == null || ry == null || !rx.parent.equals(ry.parent))
                res[i] = -1;
            else
                res[i] = rx.ratio/ry.ratio;
        }
        return res;
        
    }
    
    private Node find(String s) {
        if (!parents.containsKey(s))
            return null;
        Node n = parents.get(s);
        if (!n.parent.equals(s)) {
            Node p = find(n.parent);
            n.parent = p.parent;
            n.ratio *= p.ratio;
        }
        return n;
    }
    
    private void union(String s, String p, double ratio) {
        boolean hasS = parents.containsKey(s);
        boolean hasP = parents.containsKey(p);
        if (!hasS && !hasP) {
            parents.put(s, new Node(p, ratio));
            parents.put(p, new Node(p, 1));
        } else if (!hasP) {
            parents.put(p, new Node(s, 1/ratio));
        } else if (!hasS) {
            parents.put(s, new Node(p, ratio));
        } else {
            Node rS = find(s);
            Node rP = find(p);
            rS.parent = rP.parent;
            rS.ratio = ratio / rS.ratio * rP.ratio;
        }
    }    
}
