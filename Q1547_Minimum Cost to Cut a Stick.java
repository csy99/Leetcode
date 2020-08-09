/**
 * Created by csy99 on 8/9/20.
 */
// bottom up, convert the problem to merging sticks instead of cutting sticks
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> arr = new ArrayList();
        for (int cut: cuts)
            arr.add(cut);
        arr.add(0);
        arr.add(n);
        Collections.sort(arr);
        int k = arr.size();
        int INF = (int) 1e8;
        //dp[i][j]: the min cost to stick all sticks between A[i] and A[j]
        int[][] dp = new int[k][k];
        for (int d = 2; d < k; d++) {
            for (int i = 0; i < k - d; i++) {
                dp[i][i+d] = INF;
                for (int j = i+1; j < i+d; j++)
                    dp[i][i+d] = Math.min(dp[i][i+d], 
                        dp[i][j] + dp[j][i+d] + arr.get(i+d) - arr.get(i));
            }
        }
        return dp[0][k-1];
    }
}

// top down
class Solution {
    StringBuilder sb = new StringBuilder();
    HashMap<String, Integer> memo = new HashMap();
    public int minCost(int n, int[] cuts) {
        if (cuts.length == 0) return 0;
        Arrays.sort(cuts);
        return helper(cuts, 0, n);
    }
    
    private int helper(int[] cuts, int l, int r) {
        int cost = Integer.MAX_VALUE;
        sb.setLength(0);
        sb.append(l).append("-").append(r);
        String key = sb.toString();
        if (memo.containsKey(key)) 
            return memo.get(key);

        for (int i = 0; i < cuts.length; ++i) {
            if (cuts[i] <= l) continue;
            if (cuts[i] >= r) break;
            cost = Math.min(cost, 
                       helper(cuts, l, cuts[i]) + helper(cuts, cuts[i], r) + r - l); 
        }

        cost = cost == Integer.MAX_VALUE ? 0 : cost;
        memo.put(key, cost);
        return cost;
    }
}
