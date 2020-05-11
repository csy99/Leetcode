package Leetcode;

/**
 * Created by csy99 on 3/14/20.
 */
public class Q321_Create_Maximum_Number {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] res = new int[0];
    int m = nums1.length;
    int n = nums2.length;
    for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
      res = maxArr(res, 0, 
                    maxSubSeq(maxKElement(nums1, i), maxKElement(nums2, k - i)), 0);
    }
    return res;
  }
  
  
  private int[] maxKElement(int[] num, int k) {
    int[] res = new int[k];
    int pos = 0;
    for (int i = 0; i < num.length; i++) {
      while (pos > 0 && num.length - i > k - pos && num[i] > res[pos - 1]){
        pos--;
      }
      if (pos < k)
        res[pos++] = num[i];
    }
    return res;  
  }
  
  // pick the front one from the larger array
  private int[] maxSubSeq(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[] res = new int[m+n];
    int i = 0;
    int j = 0;
    int pos = 0;
    while (i < m || j < n) {
      res[pos++] = maxArr(nums1, i, nums2, j) == nums1 ? nums1[i++] : nums2[j++];
    }
    return res;
  }
  
  private int[] maxArr(int[] nums1, int s1, int[] nums2, int s2) {
    for (int i = s1; i < nums1.length; i++) {
      int j = s2 + i - s1;
      if (j >= nums2.length || nums1[i] > nums2[j]) return nums1;
      if (nums1[i] < nums2[j]) return nums2;
    }
    return nums2;
  }
}
