/**
 * Created by csy99 on 2/24/20.
 * <p>
 * The trapped water for slot i is determined by
 * min(leftMostHeight[i], rgithMostHeight[i]) - A[i],
 * which means the most water trapped for
 * slot i is determined by
 * the highest block left to i (exclusive),
 * and the highest block right to i, whichever is less,
 * and subtract by the height of the block itself.
 */
public class Q042_Trapping_Rain_Water {
  // dp, time: O(n), space: O(n)
  public int trap(int[] height) {
    if (height == null || height.length < 2)
      return 0;
    int len = height.length;
    int[] left = new int[len];  // left[i]: highest element so far
    int[] right = new int[len];  // right[i]: highest element from i to the end
    left[0] = height[0];
    for (int i = 1; i < len; i++)
      left[i] = Math.max(left[i-1], height[i]);
    right[len-1] = height[len-1];
    for (int j = len-2; j >= 0; j--)
      right[j] = Math.max(right[j+1], height[j]);
    
    int ans = 0;
    for (int i = 0; i < len; i++) {
      int h = Math.min(left[i], right[i]);
      ans += h - height[i];
    }
    return ans;
  }
    
  // two pointers, time: O(n), space: O(1)
  public int trap(int[] height) {
    if (height == null || height.length < 2)
      return 0;
    int len = height.length;
    int left = 0;
    int right = len - 1;
    int max_left = height[left];
    int max_right = height[right];
    
    int res = 0;
    while (left < right) {
      if (max_left < max_right) {
        res += max_left - height[left];
        max_left = Math.max(max_left, height[++left]);
      } else {
        res += max_right - height[right];
        max_right = Math.max(max_right, height[--right]);
      }
    }
    return res;
  }
}
