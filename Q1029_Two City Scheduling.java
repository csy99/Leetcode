/**
 * Created by csy99 on 9/26/21.
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        n /= 2;
        int res = 0;
        Arrays.sort(costs, (a,b)->(a[0]-a[1]-b[0]+b[1]));
        for (int i = 0; i < n; i++)
            res += costs[i][0];
        for (int i = 0; i < n; i++)
            res += costs[i+n][1];
        return res;
    }
} 
