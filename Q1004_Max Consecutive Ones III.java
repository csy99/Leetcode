/**
 * Created by csy99 on 7/23/20. 
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int l = 0;
        int r = 0;
        int longest = 0;
        int swap = 0;
        
        while (r < n) {
            if (A[r] == 1 || swap < K) {
                if (A[r] == 0)
                    swap++;
                r++;
                longest = Math.max(r-l, longest);
                continue;
            }
            while (swap >= K) {
                if (A[l] == 0)
                    swap--;
                l++;
            }
        }
        return longest;
    }
}

class Solution {
    public int longestOnes(int[] nums, int K) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[K+1];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                for (int k = 0; k <= K; k++) {
                    dp[k]++;
                    res = Math.max(res, dp[k]);
                }
            } else {
                for (int k = K; k > 0; k--) {
                    dp[k] = dp[k-1] + 1;
                    res = Math.max(res, dp[k]);
                }
                dp[0] = 0;
            }
        }
        return res;
    }
}
