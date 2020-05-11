package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class Q079_Word_Search {
  // DFS + Backtracking
  // time: O(m*n*4^l) for worst case, best case is O(l)
  int m;
  int n;
  public boolean exist(char[][] board, String word) {
    m = board.length;
    if (m == 0) return false;
    n = board[0].length;
    if (n == 0) return true;
    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (dfs(board, word, y, x, 0))
          return true;
      }
    }
    return false;
  }
  
  private boolean dfs(char[][] board, String word, int y, int x, int idx) {
    if (y < 0 || y >= m || x < 0 || x >= n || board[y][x] != word.charAt(idx))
      return false;
    if (idx == word.length() - 1)
      return true;
    char save = board[y][x];
    board[y][x] = '0';
    boolean found = 
      dfs(board, word, y-1, x, idx+1) ||
      dfs(board, word, y+1, x, idx+1) ||
      dfs(board, word, y, x-1, idx+1) ||
      dfs(board, word, y, x+1, idx+1); 
    board[y][x] = save;
    return found;
  }
}
