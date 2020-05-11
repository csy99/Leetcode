package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q347_Top_K_Frequent_Elements {
  // bucket sort
  public List<Integer> topKFrequent(int[] nums, int k) {
    List[] buckets = new List[nums.length+1];
    HashMap<Integer, Integer> freq = new HashMap();
    for (int num: nums)
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    for (int key: freq.keySet()) {
      int cnt = freq.get(key);
      if (buckets[cnt] == null)
        buckets[cnt] = new ArrayList();
      buckets[cnt].add(key);
    }
    
    List<Integer> res = new LinkedList();
    for (int i = nums.length; i >= 1; i--) {  // the lowest freq is 1
      if (buckets[i] != null)
        res.addAll(buckets[i]);
      if (res.size() == k)
        break;
    }
    return res;
  }
    

}
