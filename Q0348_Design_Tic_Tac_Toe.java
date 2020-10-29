package Leetcode;

/**
 * Created by csy99 on 10/28/20.
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 */
public class Main {
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    int n;
    
    public Main(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    int move(int row, int col, int player) {
        int p = player;
        if (player == 2) p = -1;
        rows[row] += p;
        if (rows[row] == n || rows[row] == -n)
            return player;
        cols[col] += p;
        if (cols[col] == n || cols[col] == -n)
            return player;
        if (row == col) {
            diag += p;
            if (diag == n || diag == -n)
                return player;
        }
        if (row + col == n-1) {
            antiDiag += p;
            if (antiDiag == n || antiDiag == -n)
                return player;
        }
        return 0;
    }
    
}

