/**
 * Created by csy99 on 7/7/21.
 */
// Bellman
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

// dijkastra, time: O(E log E), space: O(N+E)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final int INF = Integer.MAX_VALUE - 20000;
        int[][] adjMat = new int[n][n];
        for (int[] flight: flights)
            adjMat[flight[0]][flight[1]] = flight[2];
        // shortest distance from src to cur
        int[] distances = new int[n];
        Arrays.fill(distances, INF);
        int[] stops = new int[n];
        Arrays.fill(stops, n);
        distances[src] = 0;
        stops[src] = 0;
        // convert from num of intermediate stops to num of edges
        K += 1; 
        // 0: from, 1: total price from "src" to "from" , 2: num of edges
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[] {src, 0, 0});
        while (pq.size() > 0) {
            int[] arr = pq.poll();
            int from = arr[0];
            int price = arr[1]; 
            int numEdges = arr[2];
            if (from == dst) return price;
            if (numEdges >= K) continue;
            
            for (int to = 0; to < n; to++) {
                if (adjMat[from][to] == 0) continue;
                int total = price + adjMat[from][to];
                if (total < distances[to]) {
                    pq.add(new int[] {to, total, numEdges+1});
                    distances[to] = total;
                } else if (numEdges < stops[to]) {
                    pq.add(new int[] {to, total, numEdges+1});
                }
                stops[to] = numEdges;
            }
        }
        return -1;
    }
}
