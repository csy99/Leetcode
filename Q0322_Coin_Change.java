package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q322_Coin_Change {
  // dp
  public int coinChange(int[] coins, int amount) {
    int[] opt = new int[amount+1];    
    Arrays.fill(opt, amount+1);
    opt[0] = 0;
    for (int c: coins) {
      for (int i = c; i < amount+1; i++) {  // 不会影响比当前硬币面值小的
        opt[i] = Math.min(opt[i], opt[i-c] + 1);
      }
    }
    return opt[amount] == amount+1 ? -1 : opt[amount];
  }
  
  // dfs + greedy + prunining 
  public int coinChange(int[] coins, int amount) {
    Integer[] copy = new Integer[coins.length];
    for (int i = 0; i < coins.length; i++)
      copy[i] = coins[i];
    Arrays.sort(copy, Collections.reverseOrder());  // descending order
    int[] res = {Integer.MAX_VALUE}; 
    dfs(copy, 0, amount, 0, res);    
    return res[0] ==  Integer.MAX_VALUE ? -1 : res[0];
  }
  
  private void dfs(Integer[] coins, int idx, int amount, int count, int[] res) {
    int coin = coins[idx];
    if (idx == coins.length - 1) {  // last type of coin
      if (amount % coin == 0) 
        res[0] = Math.min(res[0], count + amount/coin);
    } else {
      for (int k = amount/coin; k >= 0 && k+count < res[0]; k--) 
        dfs(coins, idx+1, amount-k*coin, count+k, res);
    }
    return;
  }
}
