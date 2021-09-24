/**
 * Created by csy99 on 9/23.21.
 */
class Solution {

    public static int minCost(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // dp[i][j]: from i-th direction (0 left 1 right) delete j-th char;
        int[][] cost = new int[2][n + 1];
        // from left to right
        for (int j = 1; j <= n; j++) {
            cost[0][j] = Math.min(cost[0][j - 1], j - 1);
            if (arr[j - 1] == 'b')
                cost[0][j] += 2;
        }
        // from right to left
        for (int j = n - 1; j >= 0; j--) {
            cost[1][j] = Math.min(cost[1][j + 1], n - j - 1);
            if (arr[j] == 'b')
                cost[1][j] += 2;
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            int left = Math.min(cost[0][j], j);
            int right = Math.min(cost[1][j], n - j);
            res = Math.min(res, left + right);
//            System.out.printf("j=%d, cost[i][0]=%d, cost[i][1]=%d; ", j, cost[0][j], cost[1][j]);
//            System.out.printf("left=%d, right=%d, res=%d\n", left, right, res);
        }
        return res;
    }

    public static void main(String[] args) {
        // 2,5,3,10
        String[] arrs = new String[] {"aabaa", "abbaaba", "bbb", "abbbaabaabbba"};
        for (String s : arrs)
            System.out.println(minCost(s));
    }
}
