package Leetcode;

/**
 * Created by csy99 on 3/30/20.
 */
public class Q059_Spiral_Matrix_II {
  public int[][] generateMatrix(int n) {
    int[][] mat = new int[n][n];
    int num = 1;
    int left = 0;
    int right = n-1;
    int top = 0;
    int bot = n-1;
    while (left < right && top < bot) {
      for (int i = left; i < right; i++)
        mat[top][i] = num++;
      for (int i = top; i < bot; i++)
        mat[i][right] = num++;
      for (int i = right; i > left; i--)
        mat[bot][i] = num++;
      for (int i = bot; i > top; i--)
        mat[i][left] = num++;
      top++;
      bot--;
      left++;
      right--;
    }
    
    if (left == right && left == right)
      mat[n/2][n/2] = num;
    return mat;
}
