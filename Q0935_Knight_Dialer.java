/**
 * Created by csy99 on 5/4/20.
 */
class Solution {
    public int knightDialer(int N) {
        int kMod = 1_000_000_007;
        int[][] dp = new int[4][3];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = 1;
        dp[3][0] = 0;
        dp[3][2] = 0;
        int[][] dirs = new int[][] {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, 
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };
        for (int n = 1; n < N; n++) {
            int[][] cur = new int[4][3];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 3 && j != 1)
                        continue;
                    for (int d = 0; d < 8; d++) {
                        int y = i + dirs[d][0];
                        int x = j + dirs[d][1];
                        if (x < 0 || y < 0 || y >= 4 || x >= 3)
                            continue;
                        cur[i][j] = (cur[i][j] + dp[y][x]) % kMod;
                    }
                }
            }
            dp = cur;
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                res = (res + dp[i][j]) % kMod;
        return res;
    }
}
