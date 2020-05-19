/**
 * Created by csy99 on 5/19/20.
 */
class Solution {
    // time: O(n), space: O(n)
    public int subarraysWithKDistinct(int[] A, int K) {
        int cnt = 0;
        int prefix = 0;
        int[] m = new int[A.length+1];
        for (int r = 0, l = 0, size = 0; r < A.length; r++) {
            if (m[A[r]] == 0)
                size++;
            m[A[r]]++;
            if (size > K) {
                m[A[l]]--;
                l++;
                size--;
                prefix = 0;
            }
            while (m[A[l]] > 1) {
                prefix++;
                m[A[l]]--;
                l++;
            }
            if (size == K)
                cnt += prefix+1;
        }
        return cnt;
    }
}
