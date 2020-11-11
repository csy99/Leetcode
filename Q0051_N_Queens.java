package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/29/20.
 */
public class Q051_N_Queens {
    List<List<String>> res = new ArrayList();
    StringBuilder sb = new StringBuilder();
    String emptyRow = null;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        for (int j = 0; j < n; j++)
            sb.append(".");
        emptyRow = sb.toString(); 
        List<String> board = new ArrayList();
        for (int i = 0; i < n; i++)
            board.add(emptyRow);
        
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2*n+1];
        boolean[] anti = new boolean[2*n+1];
        dfs(cols, diag, anti, 0, board);
        
        return res;
    }
    
    private void dfs(boolean[] cols, boolean[] diag, boolean[] anti, int r, List<String> board) {
        if (r == n) {
            res.add(new ArrayList(board));
            return;
        }
        for (int c = 0; c < n; c++) {  // every row can only has one queen 
            if (cols[c] || diag[r-c+n-1] || anti[r+c])  // invalid
                continue;
            cols[c] = true;
            diag[r-c+n-1] = true;
            anti[r+c] = true;
            board.set(r, placeQueen(c));
            dfs(cols, diag, anti, r+1, board);
            board.set(r, emptyRow);
            cols[c] = false;
            diag[r-c+n-1] = false;
            anti[r+c] = false;
        }
    }
    
    private String placeQueen(int col) {
        sb.setCharAt(col, 'Q');
        String val = sb.toString();
        sb.setCharAt(col, '.');
        return val;
    }
}
