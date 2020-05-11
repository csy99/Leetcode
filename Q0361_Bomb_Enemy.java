package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall 
 * since the wall is too strong to be destroyed. You can only put the bomb at an empty cell.
 */
public class Q361_Bomb_Enemy {
  public int maxKilledEnemies(char[][] grid) {
    int m = grid.length;
    if (m == 0) return 0;
    int n = grid[0].length;
    if (n == 0) return 0;
    
    int max = 0;
    int[] fromUp = new int[n];
    for (int i = 0; i < m; i++) {
      int fromLeft = 0;  // enemies killed accumulated in the same row so far
      for (int j = 0; j < n; j++) {
        int total = 0;
        if (grid[i][j] == '0') {
          total = fromLeft + fromUp[j];
          // check right
          for (int k = j+1; k < n; k++) {
            if (grid[i][k] == 'W')
              break;
            if (grid[i][k] == 'E')
              total++;
          }
          // check down
          for (int k = i+1; k < m; k++) {
            if (grid[k][j] == 'W')
              break;
            if (grid[k][j] == 'E')
              total++;
          }
          max = Math.max(max, total);
        } else if (grid[i][j] == 'W') {
          fromLeft = 0;
          fromUp[j] = 0;
        } else {  // an enemy
          fromLeft++;
          fromUp[j]++;
        }
        
      }
    }
    return max;
  }
}
