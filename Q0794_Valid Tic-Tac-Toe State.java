/**
 * Created by csy99 on 10/17/20.
 */
class Solution {
    final int N = 3;
    char[][] copy = new char[N][N]; 
    
    public boolean validTicTacToe(String[] board) {
        char player_x = 'X';
        char player_o = 'O';
        int num_x = 0;
        int num_o = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = board[i].charAt(j);
                if (copy[i][j] == player_x)
                    num_x += 1;
                else if (copy[i][j] == player_o)
                    num_o += 1;
            }
        }
        if (num_o > num_x || num_x > num_o + 1) return false;
        boolean succ_x = succ(player_x);
        boolean succ_o = succ(player_o);
        if (succ_x && succ_o) return false;
        if (succ_x && num_o == num_x) return false;
        if (succ_o && num_o < num_x) return false;
        return true;
    }
    
    private boolean succ(char player) {
        // in row
        for (int i = 0; i < N; i++) {
            boolean found = true;
            for (int j = 0; j < N; j++) {
                if (copy[i][j] != player) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }
        // in col
        for (int j = 0; j < N; j++) {
            boolean found = true;
            for (int i = 0; i < N; i++) {
                if (copy[i][j] != player) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }
        // diag
        if (copy[0][0] == player && copy[1][1] == player && copy[2][2] == player)
            return true;
        // anti-diag
        if (copy[0][N-1] == player && copy[1][1] == player && copy[2][0] == player)
            return true;
        return false;
    }
}
