package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/30/20.
 */
public class Q054_Spiral_Matrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList();
    int m = matrix.length;
    if (m == 0) return res;
    int n = matrix[0].length;
    if (n == 0) return res;
    int top = 0;
    int left = 0;
    int bot = m-1;
    int right = n-1;
    while (top < bot && left < right) {
      // add top
      for (int i = left; i < right; i++) 
        res.add(matrix[top][i]);
      // add right
      for (int i = top; i < bot; i++)
        res.add(matrix[i][right]);
      // add bot
      for (int i = right; i > left; i--)
        res.add(matrix[bot][i]);
      // add left
      for (int i = bot; i > top; i--) 
        res.add(matrix[i][left]);
      top++;
      left++;
      bot--;
      right--;
    }
    if (top == bot && left == right)  // one number remaining
      res.add(matrix[top][left]);
    else if (top == bot) { // one row remaining
      for (int i = left; i <= right; i++) 
        res.add(matrix[top][i]);
    } else if (left == right) {  // one col remaining
      for (int i = top; i <= bot; i++)
        res.add(matrix[i][left]);
    }
    // the last else if is necessary!!!
    return res;
  }
}
