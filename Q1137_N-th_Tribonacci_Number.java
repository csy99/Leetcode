/**
 * Created by csy99 on 4/25/20.
 */
class Solution {
    public int tribonacci(int n) {
        if (n <= 1) return n;
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        for (int i = 3; i <= n; i++) {
            int tmp0 = t0;
            int tmp1 = t1;
            t0 = t1;
            t1 = t2;
            t2 += tmp0 + tmp1;
        }
        return t2;
    }
}
