/**
 * Created by csy99 on 5/7/20. 
 */
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[] sum = new double[A.length+1];
        double[] dp = new double[A.length+1];
        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i-1] + A[i-1];
            dp[i] = sum[i] / i;
        }
        for (int k = 2; k <= K; k++) {
            double[] tmp = new double[A.length+1];
            for (int i = k; i <= A.length; i++) {
                for (int j = k-1; j < i; j++) 
                    tmp[i] = Math.max(tmp[i], dp[j] + (sum[i]-sum[j])/(i-j));
            }
            dp = tmp;
        }
        
        return dp[A.length];
    }
}
