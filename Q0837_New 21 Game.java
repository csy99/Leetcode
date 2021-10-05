/**
 * Created by csy99 on 10/4/21.
 */
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k+maxPts)
            return 1;
        // dp[i] is the probability that we get points i at some moment.
        double[] dp = new double[n+1];
        double sum = 1;
        double res = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if (i < k)
                sum += dp[i];
            else
                res += dp[i];
            if (i >= maxPts)
                sum -= dp[i-maxPts];
        }
        return res;
    }
    
}
