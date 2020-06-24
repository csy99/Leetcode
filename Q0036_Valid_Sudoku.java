package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q036_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[10];
        // check row
        for (int i = 0; i < 9; i++) {
            used = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (used[num]) return false;
                    used[num] = true;
                }
            }
        }
        // check col
        for (int j = 0; j < 9; j++) {
            used = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (used[num]) return false;
                    used[num] = true;
                }
            }
        }
        // check box
        for (int b = 0; b < 9; b++) {
            int y = b/3*3;
            int x = (b%3)*3;
            used = new boolean[10];
            for (int i = y; i < y+3; i++) {
                for (int j = x; j < x+3; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0';
                        if (used[num]) return false;
                        used[num] = true;
                    }                    
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q036_Valid_Sudoku sol = new Q036_Valid_Sudoku();
        char[][] input = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        boolean isValid = sol.isValidSudoku(input);
        System.out.println(isValid);
    }
}
