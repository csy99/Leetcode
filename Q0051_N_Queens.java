package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/29/20.
 */
public class Q051_N_Queens {
  // every row can have exactly one queen
  List<List<String>> res = new ArrayList();
  List<String> board = new ArrayList();
  boolean[] antiDiag;
  boolean[] diag;
  boolean[] col;
  int n;
  public List<List<String>> solveNQueens(int n) {
    // create a board
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) 
      sb.append(".");
    String row = sb.toString();
    for (int i = 0; i < n; i++) 
      board.add(row);
    // init global var
    antiDiag = new boolean[2*n-1];
    diag = new boolean[2*n-1];
    col = new boolean[n];
    this.n = n;
    // backtracking
    helper(0);
    return res;
  }
  
  boolean valid(int x, int y) {
    return !col[x] && !antiDiag[x+y] && !diag[x-y+n-1];
  }
  
  void updateBoard(int x, int y, boolean occupied) {
    col[x] = occupied;
    antiDiag[x+y] = occupied;
    diag[x-y+n-1] = occupied;
    char[] r = board.get(y).toCharArray();
    r[x] = occupied? 'Q' : '.';
    board.set(y, new String(r));
  }
  
  // trying to place a queen in y-th row
  void helper(int y) {
    if (y == n) {
      res.add(new ArrayList(board));
      return;
    }
    for (int x = 0; x < n; x++) {
      if (!valid(x, y)) continue;
      updateBoard(x, y, true);
      helper(y+1);
      updateBoard(x, y, false);
    }
  }
}
