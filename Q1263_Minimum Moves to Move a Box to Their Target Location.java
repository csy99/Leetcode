/**
 * Created by csy99 on 10/15/20.
 */
class Solution {
    int m;
    int n;
    State start;
    State end;
    int[] dirs = new int[] {-1, 0, 1, 0, -1};
    char[][] grid;
    
    public int minPushBox(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        // HashSet<Integer> seen = new HashSet();
        HashSet<String> seen = new HashSet();
        start = new State();
        end = new State();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    start.by = i;
                    start.bx = j;
                } else if (grid[i][j] == 'S') {
                    start.py = i;
                    start.px = j;
                } else if (grid[i][j] == 'T') {
                    end.by = i;
                    end.bx = j;
                }
            }
        }
        Queue<State> q = new LinkedList();
        q.add(start);
        seen.add(start.key());
        int step = 0;
        while (q.size() > 0) {
            int size = q.size();
            step++;
            for (int s = 0; s < size; s++) {
                State cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    State[] tmp = new State[1];
                    tmp[0] = new State();
                    if (!canPush(cur, tmp, dirs[d], dirs[d+1]))
                        continue; 
                    State nxt = tmp[0];
                    if (seen.contains(nxt.key()))
                        continue;
                    if (nxt.bx == end.bx && nxt.by == end.by)
                        return step;
                    seen.add(nxt.key());
                    q.add(nxt);
                }
            }
        }
        return -1;
    }
    
    private boolean hasPath(State cur, int ty, int tx) {
        boolean[][] seen = new boolean[m][n];
        return dfs(cur, cur.py, cur.px, ty, tx, seen);
    }
    
    private boolean dfs(State cur, int y, int x, int ty, int tx, boolean[][] seen) {
        if (y < 0 || x < 0 || y >= m || x >= n || grid[y][x] == '#')
            return false;
        if (cur.by == y && cur.bx == x)
            return false;
        if (seen[y][x])
            return false;
        seen[y][x] = true;
        if (ty == y && tx == x)
            return true;
        for (int d = 0; d < 4; d++) 
            if (dfs(cur, y+dirs[d], x+dirs[d+1], ty, tx, seen))
                return true;
        return false;
    }
    
    private boolean canPush(State cur, State[] tmp, int dy, int dx) {
        int by = cur.by + dy;
        int bx = cur.bx + dx;
        if (by < 0 || bx < 0 || by >= m || bx >= n || grid[by][bx] == '#')
            return false;
        if (!hasPath(cur, cur.by - dy, cur.bx - dx))
            return false;
        State nxt = tmp[0];
        nxt.by = by;
        nxt.bx = bx;
        nxt.py = cur.by;
        nxt.px = cur.bx;
        return true;
    }
}

class State {
    int by;
    int bx;
    int py;
    int px;
    
    public State() {
        bx = by = px = py = 0;
    }
    
    // int key() {
    //     return ((by*20+bx)<<16) | (py*20+px);
    // }
    
    String key() {
        return by+"-"+bx+"-"+py+"-"+px;
    }
}
