/**
 * Created by csy99 on 5/15/20.
 */
class Solution {
    int m;
    int n;
    int[] dirs = new int[] {0, -1, 0, 1, 0};
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        List<Tree> trees = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = forest.get(i).get(j);
                if (num > 1) {
                    Tree t = new Tree(i, j, num);
                    trees.add(t);
                }
            }
        }
        Collections.sort(trees, (a, b) -> (a.height - b.height));
        int sy = 0;  // starting point
        int sx = 0;
        int total = 0;
        for (int i = 0; i < trees.size(); i++) {
            Tree nxt = trees.get(i);
            int ty = nxt.y;
            int tx = nxt.x;
            int step = bfs(forest, sy, sx, ty, tx);
            if (step == -1)
                return -1;
            total += step;
            // cut tree can be omitted
            sy = ty;
            sx = tx;
        }
        return total;
    }
    
    private int bfs(List<List<Integer>> forest, int sy, int sx, int ty, int tx) {
        Queue<Integer> yq = new LinkedList();
        Queue<Integer> xq = new LinkedList();
        int step = 0;
        yq.add(sy);
        xq.add(sx);
        boolean[][] visited = new boolean[m][n];
        while (yq.size() > 0) {
            int size = yq.size();
            for (int s = 0; s < size; s++) {
                int y = yq.poll();
                int x = xq.poll();
                if (y == ty && x == tx)
                    return step;
                for (int d = 0; d < 4; d++) {
                    int ny = y + dirs[d];
                    int nx = x + dirs[d+1];
                    if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                        continue;
                    if (forest.get(ny).get(nx) == 0 || visited[ny][nx])
                        continue;
                    yq.add(ny);
                    xq.add(nx);
                    visited[ny][nx] = true;   
                }
            }
            step++;
        }
        return -1;
    }
}

class Tree {
    int y;
    int x;
    int height;
    public Tree(int a, int b, int h) {
        y = a;
        x = b;
        height = h;
    }
}
