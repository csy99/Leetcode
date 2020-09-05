package Leetcode;

/**
 * Created by csy99 on 3/30/20.
 * <p>
 * You are given an n x n 2D matrix representing an image.
 */
public class Q0048_Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        int end = n-1;
        while (start < end) {
            for (int i = 0; i < n-1; i++) {
                int tmp = matrix[start][start+i];
                matrix[start][start+i] = matrix[end-i][start];
                matrix[end-i][start] = matrix[end][end-i];
                matrix[end][end-i] = matrix[start+i][end];
                matrix[start+i][end] = tmp;
            }
            start++;
            end--;
            n -= 2;  // 越往内层，需要交换的元素越少
        }
    }
}
