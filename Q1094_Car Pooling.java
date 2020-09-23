/**
 * Created by csy99 on 9/23/20.
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int N = 1000;
        int[] pickup = new int[N+1];
        int[] dropoff = new int[N+1];
        for (int[] trip: trips) {
            int num = trip[0];
            int start = trip[1];
            int end = trip[2];
            pickup[start] += num;
            dropoff[end] += num;
        }
        int cur = 0;
        for (int t = 0; t <= N; t++) {
            cur += pickup[t];
            cur -= dropoff[t];
            if (cur > capacity)
                return false;
        }
        return true;
    }
}
