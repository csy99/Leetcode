package Leetcode;

/**
 * Created by csy99 on 2/24/20.
 */
public class Q011_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int l = 0;
        int r = n-1;
        while (l < r) {
            int area = (r-l)*Math.min(height[l], height[r]);
            res = Math.max(res, area);
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }
        return res;
    }
}
