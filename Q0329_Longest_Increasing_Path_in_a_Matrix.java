package Leetcode;

/**
 * Created by csy99 on 3/31/20.
 */
public class Q329_Longest_Increasing_Path_in_a_Matrix {
  int[][] dist;
  int m;
  int n;
  public int longestIncreasingPath(int[][] matrix) {
    m = matrix.length;
    if (m == 0) return 0;
    n = matrix[0].length;
    dist = new int[m][n];
    int longest = 0;
    for (int i = 0; i < m; i++) 
      for (int j = 0; j < n; j++) 
        longest = Math.max(longest, dfs(i, j, matrix));
    return longest;
  }
  
  private int dfs(int y, int x, int[][] matrix) {
    if (dist[y][x] != 0) 
      return dist[y][x];
    dist[y][x] = 1;
    int tmp;
    if (y > 0 && matrix[y-1][x] > matrix[y][x]) {
      tmp = dfs(y-1, x, matrix);
      dist[y][x] = Math.max(dist[y][x], 1+tmp);
    }
    if (y < m-1 && matrix[y+1][x] > matrix[y][x]) {
      tmp = dfs(y+1, x, matrix);
      dist[y][x] = Math.max(dist[y][x], 1+tmp);
    }
    if (x > 0 && matrix[y][x-1] > matrix[y][x]) {
      tmp = dfs(y, x-1, matrix);
      dist[y][x] = Math.max(dist[y][x], 1+tmp);
    }
    if (x < n-1 && matrix[y][x+1] > matrix[y][x]) {
      tmp = dfs(y, x+1, matrix);
      dist[y][x] = Math.max(dist[y][x], 1+tmp);
    }
    return dist[y][x];
  }
}
