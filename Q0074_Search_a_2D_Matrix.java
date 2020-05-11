package Leetcode;

/**
 * Created by csy99 on 4/1/2020.
 */
public class Q074_Search_a_2D_Matrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;
    if (n == 0) return false;
    
    int up = 0;
    int bot = m-1;
    // find the correct row
    while (up < bot) {
      int lv_mid = (up + bot) / 2;
      if (target <= matrix[lv_mid][n-1])
        bot = lv_mid;
      else
        up = lv_mid+1;
    }
    
    int left = 0;
    int right = n-1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (matrix[bot][mid] == target)
        return true;
      else if (matrix[bot][mid] < target)
        left = mid + 1;
      else
        right = mid;
    }
    return matrix[bot][left] == target;
  }
}
