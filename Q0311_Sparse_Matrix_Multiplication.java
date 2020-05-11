package Leetcode;

/**
 * Created by csy99 on 3/30/20.
 * <p>
 * Given two sparse matrices A and B, return the result of AB.
 * <p>
 * You may assume that A's column number is equal to B's row number.
 */
public class Q311_Sparse_Matrix_Multiplication {

    // Optimized
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < C.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < C[0].length; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }

        return C;
    }

  // Naive
  public int[][] multiply(int[][] A, int[][] B) {
    int m = A.length;
    int n = B[0].length;
    int[][] res = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < A[0].length; k++)
          res[i][j] += A[i][k] * B[k][j];
      }
    }
    return res;
  }


}
