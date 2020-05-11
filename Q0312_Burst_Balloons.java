package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q312_Burst_Balloons {
  public int maxCoins(int[] nums) {
    int n = nums.length;
    int[] copy = new int[n+2];
    for (int i = 1; i <= n; i++) 
      copy[i] = nums[i-1];
    copy[0] = 1;
    copy[n+1] = 1;
    
    int[][] coin = new int[n+2][n+2];
    
    for (int len = 1; len <= n; len++) {
      for (int i = 1; i <= n-len+1; i++) {
        int j = i+len-1;
        for (int k = i; k <= j; k++) {
          coin[i][j] = Math.max(coin[i][j], coin[i][k-1] + copy[i-1]*copy[k]*copy[j+1] + coin[k+1][j]);
        }
      }
    }
    
    return coin[1][n];
  }
}
