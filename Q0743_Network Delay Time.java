/** 
 * Created by csy99 on 7/7/21.
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = 101*100;
        int[] dist = new int[n+1];
        for (int i = 1; i <= n; i++)
            dist[i] = inf;
        dist[k] = 0;
        for (int i = 1; i < n; i++) {
            for (int[] e: times)
                dist[e[1]] = Math.min(dist[e[1]], dist[e[0]] + e[2]); 
        }
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = Math.max(res, dist[i]);
        if (res == inf) return -1;
        return res;
    }
}

