package Leetcode;

/**
 * Created by csy99 on 3/29/20.
 * <p>
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF
 * as you may assume that the distance to a gate is less than 2147483647.
 * <p>
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * <p>
 * After running your function, the 2D grid should be:
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 * <p>
 * Understand the problem:
 * It is very classic backtracking problem. We can start from each gate (0 point), and searching for its neighbors. We can either use DFS or BFS solution.
 */

public class Q286_Walls_and_Gates {
  // DFS
  public void wallsAndGates(int[][] rooms) {
    if (rooms.length == 0) return;
    for (int i = 0; i < rooms.length; i++)
      for (int j = 0; j < rooms[0].length; j++)
        if (rooms[i][j] == 0)
          dfs(i, j, 0, rooms);
  }
  
  private void dfs(int i, int j, int dist, int[][] rooms) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dist) 
      return;
    rooms[i][j] = dist;
    dfs(i+1, j, dist+1, rooms);
    dfs(i-1, j, dist+1, rooms);
    dfs(i, j+1, dist+1, rooms);
    dfs(i, j-1, dist+1, rooms);
  }
}
