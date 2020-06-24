package Leetcode;

/**
 * Created by csy99 on 6/24/20.
 * A group of two or more people wants to meet and minimize the total travel distance. 
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|. Return the distance. 
 */
public class Q296_Best_Meeting_Point {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        List<Integer> hori = new ArrayList();
        List<Integer> vert = new ArrayList();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == 1) {
                    hori.add(j);
                    vert.add(i);
                }
        int res = 0;
        Collections.sort(hori);
        Collections.sort(vert);
        for (int i = 0; i < hori.size()/2; i++) {
            int left = hori.get(i);
            int right = hori.get(hori.size()-i-1);
            res += right-left;
            int top = vert.get(i);
            int bot = vert.get(vert.size()-i-1);
            res += bot-top;
        }
        return res;
    }
}
