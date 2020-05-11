/**
 * Created by csy99 on 5/8/20. 
 */
class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int INF = (int)1e7;
        // min score to triangulate A[i][j]
        int[][] score = new int[n][n];
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i + len - 1;
                score[i][j] = INF;
                for (int k = i+1; k < j; k++) {
                    score[i][j] = Math.min(score[i][j], score[i][k] + score[k][j] + A[i]*A[k]*A[j]);
                }
            }
        }
        return score[0][n-1];
    }
}
