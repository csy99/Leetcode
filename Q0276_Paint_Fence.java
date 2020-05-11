package Leetcode;

/**
 * Created by csy99 on 3/23/20.
 * <p>
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 */
public class Q276_Paint_Fence {
  public int numWays(int n, int k) {
    if (n == 0) return 0;
    if (n == 1) return k;
    // init condition: color possibility for first two posts
    int same = k;
    int diff = k*(k-1);
    for (int i = 3; i <= n; i++) {
      int preDiff = diff;
      diff = (same + diff) * (k-1);
      same = preDiff;
    }
    
    return diff+same;
  }

}
