package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 2/24/20.
 */
public class Q128_Longest_Consecutive_Sequence {
    // hashmap, time: O(n), space: O(n)
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap();
    int res = 0;
    for (int i: nums) {
      if (map.containsKey(i))
        continue;
      int left = map.get(i-1) == null ? 0 : map.get(i-1);
      int right = map.get(i+1) == null ? 0 : map.get(i+1);
      int length = left + 1 + right;
      map.put(i, length);
      map.put(i-left, length);
      map.put(i+right, length);
      res = Math.max(res, length);
    }
    return res;
  }
    
    // hash set
    //Created by rbhatnagar2 on 1/15/17.
    public static int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : num)
            set.add(e);

        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
