/**
 * Created by csy99 on 3/24/21.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            List<Integer> pos = map.getOrDefault((long) nums[i], new ArrayList());
            pos.add(i);
            map.put((long) nums[i], pos);
        }
        
        // i < j < k
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                long target = (long)2*nums[j] - nums[k];  // has to be long due to int overflow
                List<Integer> pos = map.getOrDefault(target, new ArrayList());
                for (int i: pos) {
                    if (i < j)
                        dp[j][k] += dp[i][j] + 1;
                    else
                        break;
                }
                res += dp[j][k];
            }
        }
        return res;
    }
}
