/**
 * Created by csy99 on 8/31/21.
 */
class Solution {
    // brute force, time: O(mn^2), space: O(n)
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] sum = Arrays.copyOf(grid[0], n);
        for (int i = 1; i < m; i++) {
            int[] sum2 = new int[n];
            for (int j = 0; j < n; j++) {
                int cur = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    cur = Math.min(cur, sum[k]);
                }
                sum2[j] = cur + grid[i][j];
            }
            sum = sum2; 
        }
        int res = Integer.MAX_VALUE;
        for (int s: sum)
            res = Math.min(res, s);
        return res;
    }
  
    // optimization, time: O(mn), space: O(1)
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (n == 1) return grid[0][0];
        for (int i = 1; i < m; i++) {
            int[] indices = getSmallestIndices(grid[i-1]);
            for (int j = 0; j < n; j++) {
                int top = j == indices[0] ? grid[i-1][indices[1]] : grid[i-1][indices[0]];
                grid[i][j] += top;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int s: grid[m-1])
            res = Math.min(res, s);
        return res;
    }
    
    private int[] getSmallestIndices(int[] arr) {
        int idx1 = -1;
        int idx2 = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (idx1 == -1 || arr[i] < arr[idx1]) {
                idx2 = idx1;
                idx1 = i;
            } else if (idx2 == -1 || arr[i] < arr[idx2])
                idx2 = i;
        }
        return new int[] {idx1, idx2};
    }
}
