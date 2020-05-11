package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0354_Russian_Doll_Envelopes {
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes.length <= 1)
      return envelopes.length;
    // when envs have same width, sort the height in desc order
    // ensure later no need to check width again (see * below)
    // if sort in asc order, example [1,3][1,4] will return 2
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] a, int[]b) {
        if (a[0] != b[0])
          return Integer.compare(a[0], b[0]);
        return -Integer.compare(a[1], b[1]);
      }
    });
    
    int[] maxEnv = new int[envelopes.length];
    for (int i = 0; i < envelopes.length; i++) 
      maxEnv[i] = 1; 
    int count = 1;
    for (int i = 1; i < envelopes.length; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][1] > envelopes[j][1]) {  // *the width is in asc order
          maxEnv[i] = Math.max(maxEnv[i], maxEnv[j]+1);
          if (maxEnv[i] > count)
            count = maxEnv[i];
        }
      }
    }
    return count;
  }
  
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes.length <= 1)
      return envelopes.length;
    // when envs have same width, sort the height in desc order
    // ensure later no need to check width again (see * below)
    // if sort in asc order, example [1,3][1,4] will return 2
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] a, int[]b) {
        if (a[0] != b[0])
          return Integer.compare(a[0], b[0]);
        return -Integer.compare(a[1], b[1]);
      }
    });
    
    int[] env = new int[envelopes.length];
    int size = 0;
    for (int i = 0; i < envelopes.length; i++) {
      int height = envelopes[i][1];
      int l = 0; 
      int r = size;
      while (l < r) {
        int mid = l + (r - l) / 2;
        if (env[mid] < height)
          l = mid+1;
        else
          r = mid;
      }
      env[l] = height;
      if (l == size)
        size++;
    }
    return size;
  }
}
