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

// convert the problem from calculating exactly K distinct elements to at most K distinct elements
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K-1);
    }
    
    private int atMostK(int[] A, int k) {
        int n = A.length;
        if (n == 0) return 0;
        int[] cnt = new int[n + 1];
        int res = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            cnt[A[r]]++;
            if (cnt[A[r]] == 1)
                k--;
            while (k < 0)
                if (--cnt[A[l++]] == 0) 
                    k++;
            res += r - l + 1;
        }
        return res;
    }
}
