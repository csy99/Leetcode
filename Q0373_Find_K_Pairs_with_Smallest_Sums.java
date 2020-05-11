package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q373_Find_K_Pairs_with_Smallest_Sums {
  // time: O(k logk)
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]+a[1]-b[0]-b[1]);
    LinkedList<List<Integer>> res = new LinkedList();
    if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
    for (int i = 0; i < nums1.length && i < k; i++) {
      int[] pair = new int[3];
      pair[0] = nums1[i];
      pair[1] = nums2[0];
      pair[2] = 0;  // index of nums2
      pq.offer(pair);
    }
    
    while (k > 0 && !pq.isEmpty()) {
      k--;
      int[] cur = pq.poll();
      LinkedList<Integer> elem = new LinkedList();
      elem.add(cur[0]);
      elem.add(cur[1]);
      res.add(elem);
      if (cur[2] == nums2.length - 1)
        continue;
      pq.offer(new int[] {cur[0], nums2[cur[2]+1], cur[2]+1});
    }
    return res;
  }
}
