package Leetcode;

/**
 * Created by csy99 on 6/24/20.
 */
public class Q302_Smallest_Rectangle_Enclosing_Black_Pixels {
    // Binary Search
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length; 
        int top = binarySearch(image, true, 0, x, 0, n, true);
        int bot = binarySearch(image, true, x+1, m, 0, n, false);
        int left = binarySearch(image, false, 0, y, top, bot, true);
        int right = binarySearch(image, false, y+1, n, top, bot, false);
        return (right-left)*(bot-top);
    }
    
    private int binarySearch(char[][] image, boolean hori, 
        int l, int r, int lo, int hi, boolean upperBound) {
        while (l < r) {
            int k = lo;
            int mid = (r-l)/2+l;
            while (k < hi && (hori ? image[mid][k]: image[k][mid]) == '0')
                ++k;
            if (k < hi == upperBound)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    
    // traversal, O(m*n)
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length; 
        int left = n, right = 0, top = m, bottom = 0;
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++)
                if(image[i][j] == '1') {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
        return (right - left + 1) * (bottom - top + 1);
    }
    
    // dfs, pass 80% test case, MLE.
    int top = 0;
    int bot = 0;
    int left = 0;
    int right = 0;
    int m;
    int n;
    int[] dirs = {-1, 0, 1, 0, -1};
    
    public int minArea(char[][] image, int x, int y) {
        m = image.length;
        n = image[0].length;
        top = m;
        left = n;
        dfs(image, x, y);
        if (top > bot || left > right) return 0;
        return (bot-top+1)*(right-left+1);
    }
    
    private void dfs(char[][] image, int y, int x) {
        if (y < 0 || x < 0 || y >= m || x >= n || image[y][x] == '0')
            return;
        // System.out.printf("image[%d][%d]:%c\n", y, x, image[y][x]);
        image[y][x] = '0';
        top = Math.min(top, y);
        bot = Math.max(bot, y);
        left = Math.min(left, x);
        right = Math.max(right, x);
        for (int d = 0; d < 4; d++)
            dfs(image, y+dirs[d], x+dirs[d+1]);
    }
}
