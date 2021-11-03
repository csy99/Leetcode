/**
 * Created by csy99 on 11/3/21.
 */
class Solution {
    Sea sea;
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int left= bottomLeft[0];
        int bot = bottomLeft[1];
        int right = topRight[0];
        int top =   topRight[1];
        this.sea = sea;
        return helper(bot, top, left, right);
    }

    private int helper(int bot, int top, int left, int right) {
        int mid_y = (top - bot) / 2 + bot;
        int mid_x = (right - left) / 2 + left;
        boolean hasShips = sea.hasShips(new int[]{right, top}, new int[]{left, bot});
        if (!hasShips) return 0;
        if (left == right && top == bot)
            return 1;
        else if (left == right) {
            return helper(bot, mid_y, left, right) + 
                helper(mid_y+1, top, left, right);
        } else if (top == bot) { 
            return helper(bot, top, left, mid_x) + 
                helper(bot, top, mid_x+1, right);
        } else {
            return helper(bot, mid_y, left, mid_x) +
                helper(mid_y+1, top, left, mid_x) +
                helper(bot, mid_y, mid_x+1, right) +
                helper(mid_y+1, top, mid_x+1, right);
        }
    }
}
