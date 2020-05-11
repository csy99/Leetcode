package Leetcode;

/**
 * Created by csy99 on 5/3/20.
 */
public class Q583_Delete_Operation_for_Two_Strings {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] steps = new int[m+1][n+1];
        for (int i = 1; i <= m; i++)
            steps[i][0] = i;
        for (int j = 1; j <= n; j++)
            steps[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    steps[i][j] = steps[i-1][j-1];
                else
                    steps[i][j] = 1 + Math.min(steps[i-1][j], steps[i][j-1]);
            }
        }
        return steps[m][n];
    }
}
