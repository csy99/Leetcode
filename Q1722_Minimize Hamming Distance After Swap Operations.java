/**
 * Created by csy99 on 1/10/2021.
 */
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UFS ufs = new UFS(n);
        int res = 0;
        for (int[] swap: allowedSwaps) {
            int a = swap[0];
            int b = swap[1];
            ufs.union(a,b);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int num = source[i];
            int root = ufs.find(i);
            map.putIfAbsent(root, new HashMap());
            Map<Integer, Integer> neighbors = map.get(root);
            neighbors.put(num, neighbors.getOrDefault(num, 0)+1);
            map.put(root, neighbors);
        }
        for (int i = 0; i < n; i++) {
            int num = target[i];
            int root = ufs.find(i);
            Map<Integer, Integer> neighbors = map.get(root);
            if (neighbors.getOrDefault(num, 0) == 0)
                res++;
            else
                neighbors.put(num, neighbors.get(num)-1);
        }
        return res;
    }
}

class UFS {
    int[] parents;
    int[] rank;
    
    public UFS(int n) {
        parents = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }
    
    public boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;
        if (rank[ra] < rank[rb]) {
            parents[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parents[rb] = ra;
        } else {
            parents[ra] = rb;
            rank[rb] += 1;
        }
        
        return true;
    }
    
    public int find(int a) {
        while (a != parents[a]) {
            parents[a] = parents[parents[a]];
            a = parents[a];
        }
        return a;
    }
}
