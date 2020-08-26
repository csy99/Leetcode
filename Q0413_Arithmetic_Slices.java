package Leetcode;

/**
 * Created by csy99 on 8/26/20.
 */
public class Q413_Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        int res = 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                count++;
                res += count;
            } else {
                count = 0;
            }
        }
        return res;
    }
}
