/**
 * Created by csy99 on 7/12/21.
 */
class Solution {
    int m;
    int n;
    int[] dirs = new int[] {-1,0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        if (newColor != image[sr][sc]) 
            dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int y, int x, int c, int o) {
        if (y < 0 || x < 0 || y >= m || x >= n || image[y][x] != o)
            return;
        image[y][x] = c;
        for (int d = 0; d < 4; d++)
            dfs(image, y+dirs[d], x+dirs[d+1], c, o);
    }
}
