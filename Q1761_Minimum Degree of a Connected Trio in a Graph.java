/**
 * Created by csy99 on 2/14/21.
 */
class Solution {
    // time: O(V*E)~O(n^3), space: O(V^2)
    public int minTrioDegree(int n, int[][] edges) {
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> degrees = new HashMap();
        boolean[][] hasEdge = new boolean[n+1][n+1];
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            degrees.put(a, degrees.getOrDefault(a,0)+1);
            degrees.put(b, degrees.getOrDefault(b,0)+1);
            hasEdge[a][b] = true;
            hasEdge[b][a] = true;
        }
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            for (int i = 1; i <= n; i++) {
                if (hasEdge[i][a] && hasEdge[i][b]) {
                    int deg = degrees.get(i)+degrees.get(a)+degrees.get(b);
                    deg -= 6;
                    res = Math.min(res, deg);
                }
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
