/**
 * Created by csy99 on 5/15/20. 
 */
class Solution {
    int[][] arr;
    int n;
    int[] dirs = new int[] {0, -1, 0, 1, 0};
    Queue<Integer> yq;
    Queue<Integer> xq;
    public int shortestBridge(int[][] A) {
        n = A.length;
        arr = A;
        yq = new LinkedList();
        xq = new LinkedList();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    labelIsland(i, j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        int step = 0;
        while (yq.size() > 0) {
            int size = yq.size();
            for (int s = 0; s < size; s++) {
                int y = yq.poll();
                int x = xq.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = y+dirs[d];
                    int nx = x+dirs[d+1];
                    if (!isValid(ny, nx) || arr[ny][nx] == 2)
                        continue;
                    if (arr[ny][nx] == 1)
                        return step;
                    arr[ny][nx] = 2;
                    yq.add(ny);
                    xq.add(nx);
                }
            }
            step++;
        }
        return -1;
    }
    
    private void labelIsland(int y, int x) {
        if (!isValid(y, x) || arr[y][x] != 1)
            return;
        arr[y][x] = 2;
        yq.offer(y);
        xq.offer(x);
        for (int d = 0; d < 4; d++)
            labelIsland(y+dirs[d], x+dirs[d+1]);
    }
    
    private boolean isValid(int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= n)
            return false;
        return true;
    }
}
