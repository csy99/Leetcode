/**
 * Created by csy99 on 9/2/21.
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int h = m;
        int v = n;
        for (int[] op: ops) {
            h = Math.min(op[0], h);
            v = Math.min(op[1], v);
        }
        return h * v;
    }
}
