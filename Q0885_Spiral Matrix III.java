/**
 * Created by csy99 on 10/3/20.
 */
class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[] dr = new int[] {0, 1, 0, -1};
        int[] dc = new int[] {1, 0, -1, 0};
        int[][] res = new int[R*C][];
        int t = 0;
        res[t++] = new int[] {r0, c0};
        int step = 1;
        int r = r0;
        int c = c0;
        int dir = 0;
        int cnt = 1;
        while (cnt < R*C) {
            for (int i = 1; i <= step; i++) {
                r += dr[dir];
                c += dc[dir];
                if (r >= 0 && c >= 0 && r < R && c < C) 
                    res[cnt++] = new int[]{r, c};
            }
            if (t % 2 == 0)
                step++;
            t++;
            dir++;
            dir %= 4;
        }
        return res;
    }
}
