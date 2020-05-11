package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by csy99 on 3/29/20.
 * 
 */
public class Q130_Surrounded_Regions {
  int m;
  int n;
  public void solve(char[][] board) {
    m = board.length;
    if (m <= 0) return;
    n = board[0].length;
    
    // only 'O' at the board edge should not be flipped
    for (int j = 0; j < n; j++) {
      dfs(board, 0, j);
      dfs(board, m-1, j);
    }
    for (int i = 1; i < m-1; i++) {
      dfs(board, i, 0);
      dfs(board, i, n-1);
    }  
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'G')
          board[i][j] = 'O';
        else if (board[i][j] == 'O')
          board[i][j] = 'X';
      }
    }
  }
  
  private void dfs(char[][] board, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
    board[i][j] = 'G';   // mark 'O' at the board edge (or those can connected to such 'O')
    dfs(board, i+1, j);
    dfs(board, i-1, j);
    dfs(board, i, j+1);
    dfs(board, i, j-1);
  }
}
