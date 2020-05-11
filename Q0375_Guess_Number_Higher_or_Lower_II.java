package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n.
 * You have to guess which number I picked.
 * Every time you guess wrong,
 * I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x,
 * and you guess wrong, you pay $x.
 * You win the game when you guess the number I picked.
 */
public class Q375_Guess_Number_Higher_or_Lower_II {
  public int getMoneyAmount(int n) {
    if (n == 1) return 0;  // no need to guess
    int[][] money = new int[n+1][n+1];
    
    for (int len = 2; len < n+1; len++) {
      for (int start = 1; start <= n-len+1; start++) {
        int end = start+len-1;
        money[start][end] = Integer.MAX_VALUE;
        for (int guess = start; guess < end; guess++) {
          if (guess+1 > n)
            money[start][end] = Math.min(guess + money[start][guess-1], money[start][end]);
          else
            money[start][end] = Math.min(guess + Math.max(money[start][guess-1], money[guess+1][end]), money[start][end]);
        }
      }
    }
    
    return money[1][n];
  }
}
