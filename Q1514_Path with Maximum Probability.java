/**
 * Created by csy99 on 7/12/20.
 */
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            if (!graph.containsKey(source))
                graph.put(source, new HashMap());
            if (!graph.containsKey(dest))
                graph.put(dest, new HashMap());
            graph.get(source).put(dest, succProb[i]);
            graph.get(dest).put(source, succProb[i]);
        }
        HashSet<Integer> seen = new HashSet();
        PriorityQueue<Path> pq = new PriorityQueue();
        pq.offer(new Path(start, start, 1));
        while (pq.size() > 0) {
            Path path = pq.poll();
            int from = path.from;
            int to = path.to;
            double p = path.p;
            seen.add(to);
            if (to == end) return p;
            Map<Integer, Double> childrens = graph.get(to);
            if (childrens == null) break;
            
            for (int child: childrens.keySet()) {
                if (seen.contains(child)) continue;
                pq.offer(new Path(to, child, p*childrens.get(child)));
            }
        }
        return 0;
    }
}

class Path implements Comparable<Path>{
    int from;
    int to;
    double p;
    
    public int compareTo(Path other) {
        return Double.compare(other.p, this.p);
    }   
    
    public Path(int f, int t, double pr) {
        from = f;
        to = t;
        p = pr;
    }
}
