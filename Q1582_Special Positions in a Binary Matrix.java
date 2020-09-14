/**
 * Created by csy99 on 9/13/20.
 */
class Solution {
    public int numSpecial(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                rowSum[i] += mat[i][j];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                colSum[j] += mat[i][j];
        for (int i = 0; i < m; i++) {
            if (rows[i]) continue;
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (cols[j]) continue;
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    rows[i] = true;
                    cols[j] = true;
                    res++;
                    found = true;
                    break;
                }
            }
            if (found) continue;
        }
        return res;
    }
}
