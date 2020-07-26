package Leetcode;

/**
 * Created by csy99 on 7/26/20.
 */
public class Q363_Max_Sum_of_Rectangle_No_Larger_Than_K {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int idx = 0; idx < n; idx++) {
            int[] dp = new int[m];
            for (int j = idx; j < n; j++) {
                for (int i = 0; i < m; i++)
                    dp[i] += matrix[i][j];
                int curSum = maxSubArray(dp, k);
                res = Math.max(res, curSum);
                if (k == res)
                    return res;
            }
        }
        return res;
    }
    
    private int maxSubArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        TreeSet<Integer> set = new TreeSet();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            Integer ceil = set.ceiling(curSum - k);
            if (ceil != null)
                max = Math.max(max, curSum - ceil);
            set.add(curSum);
        }
        return max;
    }
}
