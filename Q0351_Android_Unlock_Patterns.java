package Leetcode;

/**
 * Created by csy99 on 3/28/20.
 * <p>
 * Given Android 9 key lock screen and numbers m and n, where 1 <= m <= n <= 9 .
 * Count the total number of patterns of Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * <p>
 * Example:
 * <p>
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Valid move : 6 - 5 - 4 - 1 - 9 - 2
 * <p>
 * Line 1 - 9 is valid because it pass through key 5, which has been already selected in the pattern
 * Valid move : 2 - 4 - 1 - 3 - 6
 * <p>
 * Line 1 - 3 is valid because it pass through key 2, which has been already selected in the pattern
 * Invalid move : 4 - 1 - 3 - 6
 * <p>
 * Line 1 - 3 pass through key 2 which is not still selected in the pattern
 * Invalid move : 4 - 1 - 9 - 2
 * <p>
 * Line 1 - 9 pass through key 5 which is not still selected in the pattern
 */

public class Q351_Android_Unlock_Patterns {
  public int numberOfPatterns(int m, int n) {
    int cnt = 0;
    for (int num = m; num <= n; num++)
      cnt += helper(-1, num, new boolean[9]);
    return cnt;
  }
  
  private int helper(int pre, int num, boolean[] used) {
    if (num == 0)
      return 1;
    int path = 0;
    for (int i = 0; i < 9; i++) {
      if(!used[i] && valid(pre, i, used)) {
        used[i] = true;
        path += helper(i, num-1, used);
        used[i] = false;
      }
    }
    return path;
  }
  
  private boolean valid(int pre, int i, boolean[] used) {
    if (pre == -1) return true;
    // adjacent
    if ((pre + i) % 2 == 1) return true;
    // diagonal
    if (Math.abs(pre/3-i/3) == 1 && Math.abs(pre%3-i%3) == 1)
      return true;
    // visited middle
    return used[(pre+i)/2];
  }
}
