/**
 * Created by csy99 on 5/9/20. 
 */
// dfs
class Solution {
    int n;
    String[] arr;
    int[][] match;
    int best;
    int[] best_path;
    
    public String shortestSuperstring(String[] A) {
        n = A.length;
        arr = A;
        match = new int[n][n];
        best = Integer.MAX_VALUE;
        best_path = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                match[i][j] = cost(arr[i], arr[j]);
                match[j][i] = cost(arr[j], arr[i]);
            }
        }
        dfs(new boolean[n], 0, 0, new int[n]);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[best_path[0]]);
        for (int i = 1; i < n; i++) {
            int prev = best_path[i-1];
            int cur = best_path[i];
            sb.append(arr[cur].substring(arr[cur].length() - match[prev][cur]));
        }
        return sb.toString();
    }
    
    private int cost(String a, String b) {
        int d = b.length();
        for (int len = Math.min(a.length(), b.length()); len >= 1; len--) 
            if (a.substring(a.length() - len).equals(b.substring(0, len))) {
                d = b.length() - len;
                break;
            }
        return d;
    }
    
    private void dfs(boolean[] used, int d, int cur_len, int[] path) {
        if (cur_len >= best)
            return;
        if (d == n) {
            best = cur_len;
            best_path = path.clone();  // must clone, otherwise, the reference will be changed
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;
            path[d] = i;
            used[i] = true;
            int add_len = arr[i].length();
            if (d > 0) {
                int pre_idx = path[d-1];
                add_len = match[pre_idx][i];
            }
            dfs(used, d+1, add_len + cur_len, path);
            used[i] = false;
        }
    }
}
    
    
    // DP
    public String shortestSuperstring(String[] A) {
        int N = A.length;

        // Populate overlaps
        int[][] overlaps = new int[N][N];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j) if (i != j) {
                int m = Math.min(A[i].length(), A[j].length());
                for (int k = m; k >= 0; --k)
                    if (A[i].endsWith(A[j].substring(0, k))) {
                        overlaps[i][j] = k;
                        break;
                    }
            }

        // dp[mask][i] = most overlap with mask, ending with ith element
        int[][] dp = new int[1<<N][N];
        int[][] parent = new int[1<<N][N];
        for (int mask = 0; mask < (1<<N); ++mask) {
            Arrays.fill(parent[mask], -1);

            for (int bit = 0; bit < N; ++bit) if (((mask >> bit) & 1) > 0) {
                // Let's try to find dp[mask][bit].  Previously, we had
                // a collection of items represented by pmask.
                int pmask = mask ^ (1 << bit);
                if (pmask == 0) continue;
                for (int i = 0; i < N; ++i) if (((pmask >> i) & 1) > 0) {
                    // For each bit i in pmask, calculate the value
                    // if we ended with word i, then added word 'bit'.
                    int val = dp[pmask][i] + overlaps[i][bit];
                    if (val > dp[mask][bit]) {
                        dp[mask][bit] = val;
                        parent[mask][bit] = i;
                    }
                }
            }
        }

        // # Answer will have length sum(len(A[i]) for i) - max(dp[-1])
        // Reconstruct answer, first as a sequence 'perm' representing
        // the indices of each word from left to right.

        int[] perm = new int[N];
        boolean[] seen = new boolean[N];
        int t = 0;
        int mask = (1 << N) - 1;

        // p: the last element of perm (last word written left to right)
        int p = 0;
        for (int j = 0; j < N; ++j)
            if (dp[(1<<N) - 1][j] > dp[(1<<N) - 1][p])
                p = j;

        // Follow parents down backwards path that retains maximum overlap
        while (p != -1) {
            perm[t++] = p;
            seen[p] = true;
            int p2 = parent[mask][p];
            mask ^= 1 << p;
            p = p2;
        }

        // Reverse perm
        for (int i = 0; i < t/2; ++i) {
            int v = perm[i];
            perm[i] = perm[t-1-i];
            perm[t-1-i] = v;
        }

        // Fill in remaining words not yet added
        for (int i = 0; i < N; ++i) if (!seen[i])
            perm[t++] = i;

        // Reconstruct final answer given perm
        StringBuilder ans = new StringBuilder(A[perm[0]]);
        for (int i = 1; i < N; ++i) {
            int overlap = overlaps[perm[i-1]][perm[i]];
            ans.append(A[perm[i]].substring(overlap));
        }

        return ans.toString();
    }
}
