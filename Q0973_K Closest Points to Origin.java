/**
 * Created by csy99 on 8/21/20.
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]));
        for (int i = 0; i < n; i++) {
            pq.offer(points[i]);
            if (pq.size() > K)
                pq.poll();
        }
        int[][] res = new int[pq.size()][2];
        int j = 0;
        for (int[] element: pq) 
            res[j++] = element;
        return res;
    }
}
