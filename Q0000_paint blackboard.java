/**
 * Created by csy99 on 8/23/20.
 *
    有n（n在5000内）块木板，宽度是1，长度不固定，这些小木板拼接起来一块大木板。
    给一个宽度为1的刷子，每刷一次可以选择横着刷和竖着刷，过程中都不能离开木板。
    问最少要刷几次能把木板完全刷一遍。
    
    样例：
        [2 2 1 2 1]，需要返回3。
 */
public class Solution {
    public static int paint(int[] arr) {
        int n = arr.length;
        int highest = 0;
        for (int h: arr)
            highest = Math.max(highest, h);
        // dp[i][j]: the min cost to paint first i blackboards already, height can achieve j
        int[][] dp = new int[n+1][highest+1];
        for (int j = 1; j <= highest; j++)
            dp[0][j] = j;
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= highest; j++)
                dp[i][j] = n;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= highest; j++) {
                // paint vertically 
                int h = Math.min(j, arr[i-1]);
                dp[i][h] = Math.min(dp[i][h], dp[i-1][j] + 1);
                // paint horizontally
                if (arr[i-1] < n) {
                    int cur = arr[i-1];
                    if (j >= arr[i-1]) 
                        dp[i][cur] = Math.min(dp[i][cur], dp[i-1][j]);
                    else
                        dp[i][cur] = Math.min(dp[i][cur], dp[i-1][j] + cur -j);
                }
            }
        }
        int res = n;
        
        for (int j = arr[n-1]; j <= highest; j++)
            res = Math.min(res, dp[n][j]);
        return res;
    }
}
