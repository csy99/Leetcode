package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 3/25/20.
 */
// bucket sort
public class Q347_Top_K_Frequent_Elements {
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
      if (res.size() >= k)
        break;
    }
    return res;
  }
    

}
// quickselect, avg time: O(n), worst time:O(n^2), space: O(n)
class Solution {
    Map<Integer, Integer> counts = new HashMap();
    int[] unique;
    Random rand = new Random();
    
    public int[] topKFrequent(int[] nums, int k) {
        for (int num: nums)
            counts.put(num, counts.getOrDefault(num,0)+1);
        int n = counts.size();
        unique = new int[n];
        int i = 0;
        for (int num: counts.keySet()) {
            unique[i] = num;
            i++;
        }
        quickselect(0, n-1, n-k);
        return Arrays.copyOfRange(unique, n-k, n);
    }
    
    public void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private int partition(int left, int right, int p_idx) {
        int p_freq = counts.get(unique[p_idx]);
        swap(unique, p_idx, right);
        int pos = left;
        for (int i = left; i<= right; i++) {
            if (counts.get(unique[i]) < p_freq) {
                swap(unique, pos, i);
                pos++;
            }
        }
        swap(unique, pos, right);
        return pos;
    }
    
    private void quickselect(int left, int right, int k_smallest) {
        if (left >= right) return;
        int p_idx = left + rand.nextInt(right-left);
        p_idx = partition(left, right, p_idx);
        if (k_smallest == p_idx)
            return;
        if (k_smallest < p_idx)
            quickselect(left, p_idx-1, k_smallest);
        else
            quickselect(p_idx+1, right, k_smallest);
    }
    
    
}
