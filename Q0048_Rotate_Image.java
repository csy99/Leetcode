package Leetcode;

/**
 * Created by csy99 on 3/30/20.
 * <p>
 * You are given an n x n 2D matrix representing an image.
 */
public class Q0048_Rotate_Image {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    if (n == 0) return;
    int topLeft = 0;
    int botRight = n - 1;
    int level = n;
    while (level > 1) {
      for (int i = 0; i < level-1; i++) {
        int tmp = matrix[topLeft][topLeft+i];
        matrix[topLeft][topLeft+i] = matrix[botRight-i][topLeft];
        matrix[botRight-i][topLeft] = matrix[botRight][botRight-i];
        matrix[botRight][botRight-i] = matrix[topLeft+i][botRight];
        matrix[topLeft+i][botRight] = tmp;
      }
      topLeft++;
      botRight--;
      level -= 2;
    }
  }
}
