package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q072_Edit_Distance {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    // dis[i][j]: the min distance to convert word1[0~i] to word2[0~j]
    int[][] dis = new int[m+1][n+1];
    // dis[0][j] means use "" to match word2
    for (int i = 0; i <= m; i++)
      dis[i][0] = i;
    for (int j = 0; j <= n; j++)
      dis[0][j] = j;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        int replace = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
        dis[i][j] = Math.min(dis[i-1][j-1] + replace, 
                      Math.min(dis[i-1][j]+1, dis[i][j-1]+1));
      }
    }
    
    return dis[m][n];
  }
}

// Of course, one can argue that if word1[i] == word2[j], then we should use word1[i] to match word2[j] 
// and there is no need to consider other cases. 
// Based on this idea, the code for state transition can be modified as following:
    public int minDistance(String word1, String word2) {
        if (word1.length() > word2.length())
            return minDistance(word2, word1);
        int m = word1.length();
        int n = word2.length();
        int[][] cost = new int[m+1][n+1];
        for (int i = 1; i <= m; i++)
            cost[i][0] = i;
        for (int j = 1; j <= n; j++)
            cost[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cost[i][j] = cost[i-1][j-1];
                else
                    cost[i][j] = 1 + Math.min(cost[i-1][j-1], Math.min(cost[i-1][j], cost[i][j-1]));
            }
        }
        return cost[m][n];
    }
