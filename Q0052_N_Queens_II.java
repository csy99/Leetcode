package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 5/14/20.
 */
public class Q052_N_Queens_II {
    int res = 0;
    boolean[] row;
    boolean[] diag;
    boolean[] anti;
    int N;
    // every column has exactly one queen
    public int totalNQueens(int n) {
        N = n;
        row = new boolean[n];
        diag = new boolean[2*n-1];
        anti = new boolean[2*n-1];
        List<String> board = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) 
            sb.append(".");
        String s = sb.toString();
        for (int i = 0; i < n; i++)
            board.add(s);
        dfs(board, 0);
        return res;
    }
    
    private void dfs(List<String> board, int x) {
        if (x == N) {
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {  // try every row
            int diagKey = i - x + N-1;
            int antiKey = i + x;
            if (row[i] || diag[diagKey] || anti[antiKey])
                continue;
            row[i] = true;
            diag[diagKey] = true;
            anti[antiKey] = true;
            String save = board.get(i);
            StringBuilder sb = new StringBuilder(save);
            sb.setCharAt(x, 'Q');
            board.set(i, sb.toString());
            dfs(board, 1+x);
            row[i] = false;
            diag[diagKey] = false;
            anti[antiKey] = false;
            board.set(i, save);
        }
        return;
    }
}
