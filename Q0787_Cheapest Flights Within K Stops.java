/**
 * Created by csy99 on 7/7/21.
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final int INF = Integer.MAX_VALUE - 20000;
        // distance[i][j]: from src to i-th node with j nodes (stops+1)
        int[][] distance = new int[n][K+2];
        for (int i = 0; i < n; i++)
            for (int k = 0; k < K+2; k++)
                distance[i][k] = INF;
        distance[src][0] = 0;
        for (int c = 0; c < n; c++) {
            for (int[] flight: flights) {
                int s = flight[0];
                int d = flight[1];
                int w = flight[2];
                for (int k = 1; k < K+2; k++) 
                    distance[d][k] = Math.min(distance[d][k], distance[s][k-1] + w);
            }
        }
        int res = INF;
        for (int k = 1; k < K+2; k++)
            res = Math.min(res, distance[dst][k]);
        if (res >= INF) return -1;
        return res;
    }
}
