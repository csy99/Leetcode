/**
 * Created by csy99 on 12/26/20 during contest.
 */
class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int k = 0; k < n; k++)
            res[k] = k;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (res[k] == -1) continue;
                int j = res[k];
                if (grid[i][j] == 1) {
                    if (j == n-1 || grid[i][j+1] == -1)  // stuck on edge or middle
                        res[k] = -1;
                    else
                        res[k]++;
                } else {
                    if (j == 0 || grid[i][j-1] == 1)  // stuck on edge or middle
                        res[k] = -1;
                    else
                        res[k]--;
                }
            }
        }
        return res;
    }
    
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memory = new int[m][n][4];
        int[] res = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && grid[i][j] == -1) {
                    memory[i][j][0] = -1;
                    memory[i][j][3] = -1;
                } else if (j == n-1 && grid[i][j] == 1) {
                    memory[i][j][0] = -1;
                    memory[i][j][1] = -1;
                } else if (j < n-1) {
                    if (grid[i][j] == 1 && grid[i][j+1] == -1) {
                        memory[i][j][0] = -1;
                        memory[i][j][1] = -1;
                        memory[i][j+1][0] = -1;
                        memory[i][j+1][3] = -1;
                    }
                }
            }
        }
        for (int col = 0; col < n; col++) {
            int j = col;
            boolean flag = false;
            // System.out.println("--------ball " + col + " --------");
            for (int i = 0; i < m; i++) {
                if (memory[i][j][0] == -1) {
                    flag = true;
                    // System.out.printf("break 1: memory[%d][%d][%d]\n", i, j ,0);
                    break;
                }
                if (grid[i][j] == 1) {
                    if (memory[i][j][1] == -1) {
                        flag = true;
                        // System.out.println("break 2");
                        break;
                    }
                    if (j < n-1) {
                        if (memory[i][j+1][2] == -1 || memory[i][j+1][3] == -1) {
                            flag = true;
                            // System.out.println("break 3");
                            break;
                        }
                    }
                } else {
                    if (memory[i][j][3] == -1) {
                        flag = true;
                        // System.out.println("break 4");
                        break;
                    }
                    if (j > 0) {
                        if (memory[i][j-1][1] == -1 || memory[i][j-1][2] == -1) {
                            flag = true;
                            // System.out.println("break 5");
                            break;
                        }
                    }
                }
                j += grid[i][j];
            }
            if (flag)
                res[col] = -1;
            else
                res[col] = j;
        }
        return res;
    }
}
