package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0349_Intersection_of_Two_Arrays {
  // HashSet, time: O(n), space: O(n)
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
  
    // sort, time: O(n*logn), space: O(k)
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList();
        while (i < nums1.length && j < nums2.length) {
            while (i < nums1.length && i > 0 && nums1[i] == nums1[i-1])
                i++;
            while (j < nums2.length && j > 0 && nums2[j] == nums2[j-1])
                j++;
            if (i >= nums1.length || j >= nums2.length)
                break;
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        int[] copy = new int[res.size()];
        for (int k = 0; k < copy.length; k++)
            copy[k] = res.get(k);
        return copy;
    }
}
