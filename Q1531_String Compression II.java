/**
 * Created by csy99 on 7/26/20.
 */
    Integer[][][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        List<int[]> count = new ArrayList();
        char prev = ' ';
        int cnt = 0;
        // build a list of consecutive chars count, aaabbcc -> {{a, 3}, {b, 2}, {c, 2}}
        for (char c: s.toCharArray()) {
            if (c != prev) {
                if (cnt > 0)
                    count.add(new int[] {prev - 'a', cnt});
                cnt = 1;
                prev = c;
            } else
                cnt++;
        }
        count.add(new int[] {prev - 'a', cnt});
        dp = new Integer[count.size() + 1][k+1][s.length() + 1];
        return helper(count, 0, k, 0);
    }
    
    // a is a number of additional consecutive chars to be added, for cases like `aabbaa` and we delete two `b`
    private int helper(List<int[]> count, int i, int k, int a) {
        if (i == count.size())
            return 0;
        if (dp[i][k][a] != null)
            return dp[i][k][a];
        int[] cur = count.get(i);
        int c = cur[1] + a;
        int best = len(c) + helper(count, i+1, k, 0);  // try keeping everything
        // only interested when string get shorter
        for (int q: new int[] {0, 1, 9}) {
            int toRemove = c - q; // how many chars to be removed to achieve q
            if (toRemove <= k && toRemove > 0)
                best = Math.min(best, helper(count, i+1, k-toRemove, 0) + len(q));
        }
        // handle the case like 'aabbaa'
        int remain = k;
        for (int j = i+1; j < count.size() && remain >= 0; j++) {
            int[] next = count.get(j);
            if (next[0] == cur[0]) {
                best = Math.min(best, helper(count, j, remain, c));
                break;
            }
            remain -= next[1];
        }
        dp[i][k][a] = best;
        return best;
    }
    
    // length of char + its count, where n is a count of that char
	// if n == 15, l(15) = 3 -> e.g. `a15`
    private int len(int n) {
        if (n <= 1) return n;
        if (n < 10) return 2;
        if (n < 100) return 3;
        return 4;
    }
