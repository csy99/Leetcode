package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q240_Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int j = n-1;
        for (int i = 0; i < m; i++) {
            while (j > 0 && matrix[i][j] > target)
                j--;
            if (matrix[i][j] == target)
                return true;
        }
        return false;
    }
}
