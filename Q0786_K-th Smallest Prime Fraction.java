/**
 * Created by csy99 on 5/16/20.
 */
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        double l = 0;
        double r = 1;

        while (l < r) {
            double mid = (r + l) / 2;
            double res = 0;
            int cnt = 0;
            int j = 1;
            int numerator = 0;
            int denominator = 0;
            for (int i = 0; i < n-1; i++) {
                while (j < n && A[i] > mid*A[j])
                    j++;
                if (n == j) break;
                cnt += (n-j);
                double cur = (double)A[i]/A[j];
                if (cur > res) {
                    res = cur;
                    numerator = i;
                    denominator = j;
                }
            }
            
            if (cnt == K) 
                return new int[] {A[numerator], A[denominator]};
            else if (cnt < K)
                l = mid;
            else
                r = mid;
        }
        return null;
    }
}
