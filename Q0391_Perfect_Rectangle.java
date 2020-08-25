package Leetcode;

/**
 * Created by csy99 on 8/25/20.
 */
public class Q391_Perfect_Rectangle {
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        HashSet<String> corners = new HashSet();
        int area = 0;
        for (int[] rect: rectangles) {
            int bot_x = rect[0];
            int bot_y = rect[1];
            int top_x = rect[2];
            int top_y = rect[3];
            String p1 = bot_y + " " + bot_x;
            String p2 = bot_y + " " + top_x;
            String p3 = top_y + " " + top_x;
            String p4 = top_y + " " + bot_x;
            String[] points = new String[]{p1, p2, p3, p4};
            for (String point: points) {
                if (corners.contains(point))
                    corners.remove(point);
                else
                    corners.add(point);
            }
            area += (top_y - bot_y) * (top_x - bot_x);
        }
        if (corners.size() != 4)  // overlap or fail to construct a rectangle
            return false;
        int botLeft_x = Integer.MAX_VALUE;
        int botLeft_y = Integer.MAX_VALUE;
        int topRight_x = Integer.MIN_VALUE;
        int topRight_y = Integer.MIN_VALUE;
        for (String point: corners) {
            String[] coord = point.split(" ");
            int y = Integer.parseInt(coord[0]);
            int x = Integer.parseInt(coord[1]);
            botLeft_x = Math.min(botLeft_x, x);
            botLeft_y = Math.min(botLeft_y, y);
            topRight_x = Math.max(topRight_x, x);
            topRight_y = Math.max(topRight_y, y);
        }
        return area == (topRight_y - botLeft_y) * (topRight_x - botLeft_x);
    }
}
}
