/**
 * Created by csy99 on 5/19/20.
 */
class Solution {
    // two pointers, time: O(n)
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int l = 0;
        int r = n-1;
        int pos = n-1;
        while (l <= r) {
            if (A[l]*A[l] >= A[r]*A[r]) {
                res[pos] = A[l]*A[l];
                l++;
            } else {
                res[pos] = A[r]*A[r];
                r--;
            }
            pos--;
        }
        return res;
    }
}
