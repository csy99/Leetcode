package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0350_Intersection_of_Two_Arrays_II {
  // two pointers
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length)
      return intersect(nums2, nums1);
    if (nums1 == null || nums1.length == 0)
      return new int[] {};
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int l = 0;
    int r = 0;
    LinkedList<Integer> res = new LinkedList<>();
    while (l < nums1.length && r < nums2.length) {
      if (nums1[l] == nums2[r]) {
        res.add(nums1[l]);
        l++;
        r++;
      } else if (nums1[l] < nums2[r]) {
        l++;
      } else {
        r++;
      }
    }
    int[] ans = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      ans[i] = res.get(i);
    }
    return ans;
  }
    
/**
 * Created by rbhatnagar2 on 1/15/17.
 */
    public int[] intersect(int[] nums1, int[] nums2) {

        // buildMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map = buildMap(nums2);

        // buildList
        List<Integer> res = new LinkedList<Integer>();
        for (int n : nums1) {
            if (map.containsKey(n) && map.get(n) != 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        //return an array from the list
        int[] result = new int[res.size()];
        int index = 0;
        for (int i : res) {
            result[index] = i;
            index++;
        }
        return result;

    }

    private Map<Integer, Integer> buildMap(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        return map;
    }
}
