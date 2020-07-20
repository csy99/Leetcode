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
        // cost[i][j]: guarantee to guess i~j
        int[][] cost = new int[n+1][n+1];
        for (int i = 1; i < n; i++)
            cost[i][i+1] = i;
            
        for (int len = 3; len <= n; len++) {
            for (int i = 1; i <= n-len+1; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    cost[i][j] = Math.min(cost[i][j], k + Math.max(cost[i][k-1], cost[k+1][j]));
                }
            }
        }
        return cost[1][n];
    }
}
