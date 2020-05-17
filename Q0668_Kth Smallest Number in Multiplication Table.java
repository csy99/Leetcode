/**
 * Created by csy99 on 5/16/20.
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            int col = n-1;
            for (int i = 0; i < m; i++) {
                while (col >= 0 && (i+1)*(col+1) > mid)
                    col--;
                cnt += col + 1;
            }
            if (cnt < k)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
