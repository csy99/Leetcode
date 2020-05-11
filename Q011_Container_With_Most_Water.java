package Leetcode;

/**
 * Created by csy99 on 2/24/20.
 */
public class Q011_Container_With_Most_Water {
public int maxArea(int[] height) {
      int max = 0;
      int left = 0; 
      int right = height.length-1;
      while (left < right) {
        int area = Math.min(height[left], height[right]) * (right - left);
        max = Math.max(max, area);
        if (height[left] < height[right])
          left++;
        else
          right--;
      }
      return max;
    }
}
