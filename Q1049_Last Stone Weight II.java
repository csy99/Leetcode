/**
 * Created by csy99 on 5/5/20. 
 */
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        HashSet<Integer> sums = new HashSet();
        sums.add(stones[0]);
        sums.add(-stones[0]);
        for (int i = 1; i < n; i++) {
            HashSet<Integer> tmp = new HashSet();
            for (int s: sums) {
                tmp.add(s - stones[i]);
                tmp.add(s + stones[i]);
            }
            sums = tmp;
        }
        int res = 200;
        for (int s: sums)
            res = Math.min(res, Math.abs(s));
        return res;
    }
    
    /**
        This question eaquals to partition an array into 2 subsets whose difference is minimal
        (1) S1 + S2  = S
        (2) S1 - S2 = diff  
        ==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2 
        Now we should find the maximum of S2 , range from 0 to S / 2, using dp can solve this
        same as 494. Target Sum
    */
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total = 0;
        for (int i = 0; i < stones.length; i++)
            total += stones[i];
        int S2 = 0;
        boolean[] dp = new boolean[total+1];
        dp[0] = true;
        for (int s: stones) {
            boolean[] cur = dp.clone();
            for (int i = s; i <= total/2; i++) {
                if (dp[i - s]) {
                    cur[i] = true;
                    S2 = Math.max(S2, i);
                }
            }
            dp = cur;
        }
        return total - 2 * S2;
    }
}
