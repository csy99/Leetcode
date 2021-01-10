/**
 * Created by csy99 on 1/10/21.
 */
// dfs + prunning
class Solution {
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        Arrays.sort(jobs);
        if (k >= n) 
            return jobs[n-1];
        dfs(jobs, n-1, new int[k]);
        return res;
    }
    
    private void dfs(int[] jobs, int idx, int[] cur) {
        int max = findMax(cur);
        if (max >= res) 
            return;
        if (idx == -1) {
            res = max;
            return;
        }
        for (int i = 0; i < cur.length; i++) {
            if (i > 0 && cur[i] == cur[i-1])
                continue;
            cur[i] += jobs[idx];
            dfs(jobs, idx-1, cur);
            cur[i] -= jobs[idx];
        }
    }
    
    private int findMax(int[] arr) {
        int max = 0;
        for (int num: arr)
            max = Math.max(num, max);
        return max;
    }
}
