/**
 * Created by csy99 on 8/23/20.
 */
class Solution {
    HashMap<Integer, Integer> mem = new HashMap();
    int n;
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        int relative = helper(stoneValue, 0);
        if (relative > 0)
            return "Alice";
        else if (relative == 0)
            return "Tie";
        else
            return "Bob";
    }
    
    private int helper(int[] stones, int start) {
        if (start >= n)
            return 0;
        if (mem.containsKey(start))
            return mem.get(start);
        int best = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < 3; i++) {
            if (start+i >= n) break;
            cur += stones[start+i];
            best = Math.max(best, cur - helper(stones, i+start+1));
        }
        mem.put(start, best);
        return best;
    }
}
