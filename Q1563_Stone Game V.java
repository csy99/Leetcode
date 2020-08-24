/**
 * Created by csy99 on 8/23/20.
 */
class Solution {
    HashMap<String, Integer> mem = new HashMap();
    int[] sum;
    int n;
    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        sum = new int[n+1];
        for (int i = 0; i < n; i++)
            sum[i+1] = sum[i] + stoneValue[i];
        return helper(stoneValue, 0, n-1);
    }
    
    private int helper(int[] stones, int l, int r) {
        if (l >= n || r < 0 || l >= r)
            return 0;
        // if (l == r)
            // return stones[l];
        String key = l + " " + r;
        if (mem.containsKey(key))
            return mem.get(key);
        int best = 0;
        int cur = 0;
        for (int k = l; k < r; k++) { // the first subarray should include k-th element
            int first = sum[k+1] - sum[l];
            int second = sum[r+1] - sum[k+1];
            if (first <= second) 
                best = Math.max(best, first + helper(stones, l, k));
            if (first >= second) 
                best = Math.max(best, second + helper(stones, k+1, r));
        }        
        mem.put(key, best);
        return best;
    }
}
