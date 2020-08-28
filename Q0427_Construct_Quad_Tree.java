package Leetcode;

public class Q427_Construct_Quad_Tree {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(grid, 0, n-1, 0, n-1);
    }
    
    private Node helper(int[][] grid, int top, int bot, int left, int right) {
        if (top > bot || left > right) return null;
        boolean same = true;
        for (int i = top; i <= bot; i++) 
            for (int j = left; j <= right; j++) {
                if (grid[i][j] != grid[top][left]) {
                    same = false;
                    break;
                }
            }
        if (same) 
            return new Node(grid[top][left] == 1, true); 
        Node root = new Node();
        int rowMid = top + (bot - top) / 2;
        int colMid = left + (right - left) / 2;
        root.topLeft = helper(grid, top, rowMid, left, colMid);
        root.topRight = helper(grid, top, rowMid, colMid+1, right);
        root.bottomLeft = helper(grid, rowMid+1, bot, left, colMid);
        root.bottomRight = helper(grid, rowMid+1, bot, colMid+1, right);
        return root;
    }
}
