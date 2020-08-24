/**
 * Created by csy99 on 8/23/20.
 */
class Solution {
    
    HashMap<Integer, Integer> mem = new HashMap();
    public boolean winnerSquareGame(int n) {
        int res = helper(n);
        if (res > 0)
            return true;
        return false;
    }
    
    private int helper(int n) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 1;
        if (mem.containsKey(n))
            return mem.get(n);
        int best = -2;
        for (int num = 1; num*num <= n; num++) {
            best = Math.max(best, -helper(n-num*num));
            if (best > 0)
                break;
        }
        
        mem.put(n, best);
        return best;
    }
}
