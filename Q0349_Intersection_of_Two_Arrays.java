package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0349_Intersection_of_Two_Arrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) 
      return intersection(nums2, nums1);
    HashSet<Integer> set = new HashSet<>();
    for (int i: nums1) {
      set.add(i);
    }
    HashSet<Integer> intersect = new HashSet<Integer>(); 
    for (int i = 0; i < nums2.length; i++) {
      if (set.contains(nums2[i]))
        intersect.add(nums2[i]);
    }
    Iterator<Integer> iter = intersect.iterator();
    int[] res = new int[intersect.size()];
    int pos = 0;
    while(iter.hasNext())
      res[pos++] = iter.next();
    return res;
  }
}
