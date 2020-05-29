/**
 * Created by csy99 on 5/28/20. 
 */
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        long[] sum = new long[n+1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i-1] + (long) A[i-1];
        // Want smallest r-l with sum[r]-sum[l] >= K
        int len = n + 1;
        Deque<Integer> monoq = new LinkedList();
        monoq.addLast(0);
        for (int r = 1; r <= n; r++) {
            // if x1<x2 && sum[x2]<=sum[x1], then the sliding window with 
            // right bound of r will never have left bound of x1.
            // because r-x2 is shorter and may meet the requirement
            while (monoq.size() > 0 && sum[r] <= sum[monoq.getLast()])
                monoq.removeLast();
            // monoq.getFirst() is left bound
            while (monoq.size() > 0 && sum[r] >= sum[monoq.getFirst()]+K)
                len = Math.min(len, r-monoq.removeFirst());
            monoq.addLast(r);
        }
        return len > n ? -1 : len;
    }
}
