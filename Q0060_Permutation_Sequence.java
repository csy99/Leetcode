package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/26/20.
 */
public class Q060_Permutation_Sequence {
  public String getPermutation(int n, int k) {
    char[] holder = new char[n];
    ArrayList<Integer> rest = new ArrayList();  // the numbers that have not been used
    int[] factor = new int[n+1];  // num of permutation for n = i
    factor[0] = 1;
    for (int i = 1; i < n+1; i++) {
      factor[i] = factor[i-1] * i;
      rest.add(i);
    }
    // starting from the most significant bit
    k--;  // 0-based index
    for (int i = 0; i < n; i++) {
      // k/factor[n-1-i] is the num of permutations in each group (group by MSB)
      int cur = rest.remove(k / factor[n-1-i]);
      holder[i] = (char) (cur + '0');
      k = k % factor[n-1-i];
    }
    return new String(holder);
  }
}
