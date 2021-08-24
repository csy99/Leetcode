package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q215_Kth_Largest_Element_in_an_Array {
  // sort
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
  }
  
  // priority queue
  public int findKthLargest(int[] nums, int k) {
    if (nums.length == 0 || k < 0) return 0;
    PriorityQueue<Integer> pq = new PriorityQueue();
    for (int num: nums) {
      pq.offer(num);
      if (pq.size() > k)
        pq.poll();
    }
    
    return pq.peek();
  }

  // partition
  public int findKthLargest(int[] nums, int k) {
    if (nums.length == 0 || k < 0) return 0;
    randomize(nums);  // better choose the pivot
    int left = 0;
    int right = nums.length-1;
    int kSmallest = nums.length - k + 1;
    while (true) {
      int pIdx = partition(nums, left, right);
      if (pIdx+1 == kSmallest)
        return nums[pIdx];
      else if (kSmallest < pIdx + 1)
        right = pIdx-1;
      else
        left = pIdx+1;
    }
  }
  
  private void randomize(int[] nums) {
    Random rand = new Random();
    for (int i = nums.length - 1; i > 0; i--) {
      int idx = rand.nextInt(i+1);
      swap(nums, idx, i);
    }
  } 
  
  private void swap(int[] nums, int l, int r) {
    int tmp = nums[r];
    nums[r] = nums[l];
    nums[l] = tmp;
  }
  
  private int partition(int[] nums, int l, int r) {
    int slow = l-1;
    int fast = l;
    while (fast < r) {  // when fast = pivot, the loop exits
      if (nums[fast] <= nums[r]) 
        swap(nums, ++slow, fast);
      fast++;
    }
    swap(nums, ++slow, fast);
    return slow;
  }
}
    // quickselect
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    private int quickSelect(int[] nums, int l, int r, int k) {
        int p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= nums[r]) {
                swap(nums, p, i);
                p++;
            }
        }
        swap(nums, p, r);
        
        int cnt = r - p + 1;
        if (cnt == k) return nums[p];
        if (cnt > k)
            return quickSelect(nums, p+1, r, k);
        return quickSelect(nums, l, p-1, k-cnt);
    }
