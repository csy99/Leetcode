package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q037_Sudoku_Solver {
  boolean[][] rows = new boolean[9][10];
  boolean[][] cols = new boolean[9][10];
  boolean[][] box = new boolean[9][10];
  public void solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i ++) {
      for (int j = 0; j < 9; j++) {
        char c = board[i][j];
        if (c != '.') {
          int num = c - '0';
          rows[i][num] = true;
          cols[j][num] = true;
          box[i/3*3 + j/3][num] = true;
        }
      }
    }
    fill(board, 0, 0);
  }
  
  private boolean fill(char[][] board, int y, int x) {
    if (y == 9) return true;
    int nx = (x+1)%9;
    int ny = nx == 0? y+1 : y;
    if (board[y][x] != '.')
      return fill(board, ny, nx);
    for (int i = 1; i <= 9; i++) {
      int bx = x/3;
      int by = y/3;
      int b_idx = by * 3 + bx;
      if (!rows[y][i] && !cols[x][i] && !box[b_idx][i]) {
        rows[y][i] = true;
        cols[x][i] = true;
        box[b_idx][i] = true;
        board[y][x] = (char)(i + '0');
        if (fill(board, ny, nx))
          return true;
        board[y][x] = '.';
        rows[y][i] = false;
        cols[x][i] = false;
        box[b_idx][i] = false;
      }
    }
    return false;
  }
}
