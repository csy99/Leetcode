/**
 * Created by csy99 on 8/19/20.
 */
public class Solution {
    int m;
    int n;
    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        while (true) {
            boolean change = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.abs(board[i][j]);
                    if (i < m-2 && val != 0 && Math.abs(board[i+1][j]) == val 
                       && Math.abs(board[i+2][j]) == val) {
                        board[i][j] = board[i+1][j] = board[i+2][j] = -val;
                        change = true;
                    }
                    if (j < n-2 && val != 0 && Math.abs(board[i][j + 1]) == val 
                       && Math.abs(board[i][j + 2]) == val) {
                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                        change = true;
                    }
                }
            }
            if (!change)
                break;
            // fill in the empty cell
            for (int j = 0; j < n; j++) {
                int wi = m - 1;
                for (int i = m-1; i >= 0; i--) {
                    if (board[i][j] > 0)
                        board[wi--][j] = board[i][j];
                }
                while (wi >= 0)
                    board[wi--][j] = 0;
            }
        }
        return board;
    }
    
}
