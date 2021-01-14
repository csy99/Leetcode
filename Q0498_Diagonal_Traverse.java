package Leetcode;

/**
 * Created by csy99 on 1/13/21.
 */
class Solution {
    // time: O(m*n*log(m*n)), space:(m*n)
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        if (n == 0) return new int[0];
        int[][] arr = new int[m*n][3];
        int index = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[index++] = new int[] {i+j, j, matrix[i][j]};
        Arrays.sort(arr, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               if (a[0] != b[0])
                   return a[0] - b[0];
               if (a[0] % 2 == 0)
                   return a[1] - b[1];
               return b[1] - a[1];
           } 
        });
        int[] res = new int[m*n];
        for (int i = 0; i < res.length; i++)
            res[i] = arr[i][2];
        return res;
    }
}
