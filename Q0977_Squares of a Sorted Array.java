/**
 * Created by csy99 on 5/19/20.
 */
class Solution {
    // merge sort, time: O(n)
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int j = 0;
        while (j < n && A[j] < 0)
            j++;
        int i = j-1;
        int[] res = new int[n];
        int t = 0;
        while (i >= 0 && j < n) {
            if (A[i]*A[i] < A[j]*A[j]) {
                res[t] = A[i]*A[i];
                i--;
            } else {
                res[t] = A[j]*A[j];
                j++;
            }
            t++;
        }
        while (i >= 0) {
            res[t++] = A[i]*A[i];
            i--;
        }
        while (j < n) {
            res[t++] = A[j]*A[j];
            j++;
        }
        return res;
    }
}
