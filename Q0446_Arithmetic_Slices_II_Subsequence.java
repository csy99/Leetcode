package Leetcode;

/**
 * Created by csy99 on 3/24/21.
 */
public class Q446_Arithmetic_Slices_II_Subsequence {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            List<Integer> pos = map.getOrDefault((long)A[i], new ArrayList());
            pos.add(i);
            map.put((long)A[i], pos);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2*(long)A[j] - A[i];  // the diff can be negative
                if (map.containsKey(target)) {
                    for (int k: map.get(target)) {
                        if (k < j) 
                            dp[i][j] += dp[j][k]+1;
                        else
                            break;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
