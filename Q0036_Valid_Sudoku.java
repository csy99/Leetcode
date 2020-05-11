package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q036_Valid_Sudoku {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length != 9 || board[0].length != 9)
      return false;
    int n = 9;
    boolean[] taken; // = new boolean[9];
    // check row
    for (int i = 0; i < n; i++) {
      taken = new boolean[9];
      for (int j = 0; j < n; j++) {
        if (Character.isDigit(board[i][j])) {
          int num = board[i][j] - '0';
          if (taken[num-1]) 
            return false;
          taken[num-1] = true;
        }
      }
    }
    
    // check column
    for (int j = 0; j < n; j++) {
      taken = new boolean[9];
      for (int i = 0; i < n; i++) {
        if (Character.isDigit(board[i][j])) {
          int num = board[i][j] - '0';
          if (taken[num-1]) 
            return false;
          taken[num-1] = true;
        }
      }
    }
    
    // check 3*3 box
    for (int b = 0; b < n; b++) {
      taken = new boolean[9];
      for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
          char tmp = board[r + b/3*3][c + (b%3)*3];
          if (tmp != '.') {
            int num = tmp - '0';
            if (taken[num-1])
              return false;
            taken[num-1] = true;
          }
        }
      }
    }
    
    
    return true;
  }

    public static void main(String[] args) {
        Q036_Valid_Sudoku sol = new Q036_Valid_Sudoku();
        char[][] input = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        boolean isValid = sol.isValidSudoku(input);
        System.out.println(isValid);
    }
}
