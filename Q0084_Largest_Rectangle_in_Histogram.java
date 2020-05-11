package Leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q084_Largest_Rectangle_in_Histogram {
  // time: O(n), mono stack
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) return 0;
    int res = 0;
    Stack<Integer> h = new Stack();
    for (int cur = 0; cur < heights.length; cur++) {
      if (h.size() == 0 || heights[cur] >= heights[h.peek()]) {
        h.push(cur);
      } else {
        // for each height, compute the area of rectangle
        int right = cur;
        int hiIdx = h.pop();
        while (h.size() != 0 && heights[h.peek()] == heights[hiIdx])
          hiIdx = h.pop();
        int left = h.size() == 0 ? -1:h.peek();
        res = Math.max(res, (right-left-1) * heights[hiIdx]);
        cur--;
      }
    }
    while (!h.isEmpty()) {
      int hiIdx = h.pop();
      int left = h.isEmpty()? -1: h.peek();
      res = Math.max(res, (heights.length-left-1) * heights[hiIdx]);
    }
    return res;
  }

    public static void main(String args[]) {
        Q084_Largest_Rectangle_in_Histogram mh = new Q084_Largest_Rectangle_in_Histogram();
        int input[] = {2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2};
        int maxArea = mh.largestRectangleArea(input);
        System.out.println(maxArea);
    }
}
