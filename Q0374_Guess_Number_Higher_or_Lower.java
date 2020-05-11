package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q374_Guess_Number_Higher_or_Lower {
  public int guessNumber(int n) {
    int low = 1;
    int high = n;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (guess(mid) == 0)
        return mid;
      if (guess(mid) > 0)
        low = mid + 1;
      else
        high = mid;
    }
    return low;
  }
}
