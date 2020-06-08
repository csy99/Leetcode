package Leetcode;

/**
 * Created by csy99 on 3/14/20.
 */
public class Q289_Game_of_Life {
    public void gameOfLife(int[][] board) {
      int m = board.length;
      int n = m == 0 ? 0 : board[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          int lives = 0;  // count how many neighbors (including self) are living
          for (int x = Math.max(0, i-1); x < Math.min(i+2, m); x++) {
            for (int y = Math.max(0, j-1); y < Math.min(j+2, n); y++) {
              if ((board[x][y] & 1) == 1) {
                lives++;
              }
            }
          }
          if (lives == 3 || lives - board[i][j] == 3)  // lives in the next generation
            board[i][j] |= 0b10;
        }
      }
      
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          board[i][j] >>= 1;
        }
      }
    }
}
