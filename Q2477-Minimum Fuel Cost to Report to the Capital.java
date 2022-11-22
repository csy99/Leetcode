/**
 * Created by csy99 on 11/21/22.
 */
// dfs
// time: O(n), space: O(n)
class Solution {
    long res = 0;
    Stack<Integer> dist = new Stack();
    
    int n;
    int seats;
    boolean[] seen;
    List<Integer>[] graph;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        n = roads.length+1;
        this.seats = seats;
        graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList();
        seen = new boolean[n];
        for (int[] road: roads) {
            int u = road[0];
            int v = road[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        traverse(0);
        return res;
    }
    
    private int traverse(int cur) {
        if (seen[cur]) return 0;
        seen[cur] = true;
        int people = 1;
        for (int nei: graph[cur]) 
            people += traverse(nei);
        if (cur != 0)
            res += (people-1) / seats + 1;
        return people;
    }
}
