package Leetcode;

/**
 * Created by csy99 on 9/1/20.
 */
public class Q440_K_th_Smallest_in_Lexicographical_Order {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        while (k > 1) {
            long gap = findGap(cur, cur+1, n);
            if (gap < k) {
                cur++;
                k -= gap;
            } else {
                cur *= 10;
                k--;
            }
        }
        return (int) cur;
    }
    
    private long findGap(long a, long b, int n) {
        long res = 0;
        while (a <= n) {
            res += Math.min(n+1, b) - a;
            a *= 10;
            b *= 10;
        }
        return res;
    }
}
