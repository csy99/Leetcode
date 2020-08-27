package Leetcode;

/**
 * Created by csy99 on 8/27/20.
 */
public class Q419_Battleships_in_a_Board {
    public int countBattleships(char[][] board) {
        int cnt = 0;
        int m = board.length;
        if (m == 0) return cnt;
        int n = board[0].length;
        if (n == 0) return cnt;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                if (i > 0 && board[i-1][j] == 'X')
                    continue;
                if (j > 0 && board[i][j-1] == 'X')
                    continue;
                cnt++;
            }
        
        return cnt;
    }
}
