package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q037_Sudoku_Solver {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] box = new boolean[9][10];
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) 
            for (int j = 0; j < 9; j++) 
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    int boxKey = boxKey(i, j);
                    box[boxKey][num] = true;
                }
        dfs(board, 0, 0);
    }
    
    private boolean dfs(char[][] board, int y, int x) {
        if (y == 9) return true;
        int nx = (x+1)%9;
        int ny = nx == 0 ? y+1:y;
        if (board[y][x] != '.') 
            return dfs(board, ny, nx);
        
        for (int num = 1; num < 10; num++) {
            int boxKey = boxKey(y, x);
            if (row[y][num] || col[x][num] || box[boxKey][num])
                continue;
            row[y][num] = true;
            col[x][num] = true;
            box[boxKey][num] = true;
            board[y][x] = (char)('0' + num);
            if (dfs(board, ny, nx))
                return true;
            board[y][x] = '.';
            box[boxKey][num] = false;
            col[x][num] = false;
            row[y][num] = false;
        }
        return false;
    }
    
    private int boxKey(int i, int j) {
        return i / 3 * 3 + j / 3;
    }
}
