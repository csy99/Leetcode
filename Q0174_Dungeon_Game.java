package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q174_Dungeon_Game {
      public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0) return 0;
        int n = dungeon[0].length;
        if (n == 0) return 0;
        // hp[i][j]: the min hp required at dungeon[i][j] to save princess
        int[][] hp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            hp[i][n] = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++)
            hp[m][j] = Integer.MAX_VALUE;
        hp[m][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                hp[i][j] = Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
                if (hp[i][j] <= 0)
                    hp[i][j] = 1;
            }
        }
        return hp[0][0];
    }
}
