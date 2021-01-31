/**
 * Created by csy99 on 1/31/2021. 
 */
class Solution {
    public boolean[] canEat(int[] candies, int[][] queries) {
        int m = candies.length;
        int n = queries.length;
        long[] sum = new long[m+1];
        for (int i = 1; i <= m; i++)
            sum[i] = candies[i-1] + sum[i-1];
        boolean[] res = new boolean[n];
        for (int j = 0; j < n; j++) {
            int[] query = queries[j];
            int type = query[0];
            int day = query[1];
            long limit = query[2];
            if (sum[type] < (day+1)*limit && day <= sum[type+1]-1)
                res[j] = true;
        }
        return res;
    }
}
