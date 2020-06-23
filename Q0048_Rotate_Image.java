package Leetcode;

/**
 * Created by csy99 on 3/30/20.
 * <p>
 * You are given an n x n 2D matrix representing an image.
 */
public class Q0048_Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) return;
        int top = 0;
        int bot = n-1;
        int left = 0;
        int right = n-1;
        int level = n;
        while (left < right) {
            for (int i = 0; i < level-1; i++) {
                int tmp = matrix[top][left+i];
                matrix[top][left+i] = matrix[bot-i][left];
                matrix[bot-i][left] = matrix[bot][right-i];
                matrix[bot][right-i] = matrix[top+i][right];
                matrix[top+i][right] = tmp;
            }
            left++;
            right--;
            top++;
            bot--;
            level -= 2;
        }
    }
