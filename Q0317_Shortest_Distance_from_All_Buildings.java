package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
 You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
  Each 0 marks an empty land which you can pass by freely.
  Each 1 marks a building which you cannot pass through.
  Each 2 marks an obstacle which you cannot pass through.
 Example 1

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation:
In this example, there are three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 */
public class Q317_Shortest_Distance_from_All_Buildings {
  int m = 0;
  int n = 0;
  int[][] canReach;
  int[][] dist;
  int[] rowDir = new int[] {0, 0, -1, 1};
  int[] colDir = new int[] {-1, 1, 0, 0};
  /**
   * @param grid: the 2D grid
   * @return: the shortest distance
   */
  public int shortestDistance(int[][] grid) {
    m = grid.length;
    if (m == 0) return -1;
    n = grid[0].length;
    if (n == 0) return -1;
    canReach = new int[m][n];
    dist = new int[m][n];
    
    int totalBuilding = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          totalBuilding++;
          if (!bfs(grid, i, j))
            return -1;
        }
      }
    }
    
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (canReach[i][j] == totalBuilding && dist[i][j] < minDist) 
          minDist = dist[i][j];
      }
    }
    return minDist == Integer.MAX_VALUE? -1:minDist;
  }
  
  private boolean isValid(int[][] grid, int y, int x, boolean[][] visited) {
    if (y < 0 || y >= m || x < 0 || x >= n)
      return false;
    if (grid[y][x] == 2)
      return false;
    if (visited[y][x])
      return false;
    return true;
  }
  
  private boolean bfs(int[][]grid, int y, int x) {
    Queue<int[]> q = new LinkedList();
    boolean[][] visited = new boolean[m][n];
    q.offer(new int[] {y, x});
    visited[y][x] = true;
    int d = 0;
    while (!q.isEmpty()) {
      d++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        for (int dir = 0; dir < 4; dir++) {
          int r = cur[0] + rowDir[dir];
          int c = cur[1] + colDir[dir];
          if (!isValid(grid, r, c, visited))
            continue;
          if (grid[r][c] == 0) {
            q.offer(new int[] {r, c});
            dist[r][c] += d;
            canReach[r][c]++;
          } 
          visited[r][c] = true;
          
        }
      }
    }
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !visited[i][j])
          return false;
      }
    }
    return true;
  }
}
