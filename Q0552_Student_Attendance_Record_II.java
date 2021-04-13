package Leetcode;

public class Q552_Student_Attendance_Record_II {
    int kmod = (int)1e9+7;
    public int checkRecord(int n) {
        if (n == 1) return 3;
        // dp[i][j][k], i represents length, j represents cnt of A, k represents consec L
        long[][][] dp = new long[n+1][2][3];
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    // end with P
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % kmod;
                    // end with A
                    if (j == 0) {
                        dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % kmod;
                    }
                    // end with L
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % kmod;
                    }
                }
            }
        }
        long res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + dp[n][j][k]) % kmod;
            }
        }
        return (int) res;
    }
}
