package Leetcode;

/**
 * Created by csy99 on 3/30/20.
 */
public class Q073_Set_Matrix_Zeroes {
  public void setZeroes(int[][] matrix) {
    if (matrix.length == 0) return;
    int m = matrix.length;
    int n = matrix[0].length;
    // record whether we should set first row/col to be all 0s
    boolean firstRow = false;
    boolean firstCol = false;
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        firstRow = true;
        break;
      }
    }
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        firstCol = true;
        break;
      }
    }
    // use number at first row/col as indicator
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    // traversing second time to flip 
    for (int i = 1; i < m; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < n; j++) 
          matrix[i][j] = 0;
      }
    }
    for (int j = 1; j < n; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < m; i++) 
          matrix[i][j] = 0;
      }
    }
    // check if first row/col should be set to 0
    if (firstRow) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
    if (firstCol) {
      for (int i = 0; i < m; i++)
        matrix[i][0] = 0;
    }
    return;
  }
}
