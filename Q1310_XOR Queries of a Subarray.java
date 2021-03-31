/**
 * Created by csy99 on 3/31/2021.
 */
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] res = new int[m];
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefix[i] = arr[i] ^ prefix[i-1];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0)
                res[i] = prefix[r];
            else
                res[i] = prefix[r] ^ prefix[l-1];
        }
        return res;
    }
}
