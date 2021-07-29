package Leetcode;

/**
 * Created by csy99 on 7/29/21.
 */
public class Q505_The_Maze_II {
    public int shortestDistance(int[][] maze, int[] start, int[] end) {
        int[] dirs = new int[] {-1,0,1,0,-1};
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = Integer.MAX_VALUE;
        dist[start[0]][start[1]] = 0;
        Queue<Integer> qy = new LinkedList();
        Queue<Integer> qx = new LinkedList();
        qy.add(start[0]);
        qx.add(start[1]);
        while (qy.size() > 0) {
            int y = qy.poll();
            int x = qx.poll();
            for (int d = 0; d < 4; d++) {
                int ny = y + dirs[d];
                int nx = x + dirs[d+1];
                int step = 0;
                while (ny >= 0 && ny < m && nx >= 0 && nx < n && maze[ny][nx] == 0) {
                    ny += dirs[d];
                    nx += dirs[d+1];
                    step++;
                }
                ny -= dirs[d];
                nx -= dirs[d+1];
                if (dist[y][x] + step < dist[ny][nx]) {
                    qy.add(ny);
                    qx.add(nx);
                    dist[ny][nx] = dist[y][x] + step;
                }
            }
        }
        if (dist[end[0]][end[1]] == Integer.MAX_VALUE)
            return -1;
        return dist[end[0]][end[1]];
    }
}
