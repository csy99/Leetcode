package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class Q088_Merge_Sorted_Array {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int idx = m + n - 1;
    int l = m - 1;
    int r = n - 1;
    while (l >= 0 && r >= 0) {
      if (nums2[r] > nums1[l]) 
        nums1[idx--] = nums2[r--];
      else 
        nums1[idx--] = nums1[l--];
    }
    while (l >= 0)  // all elements in nums2 have been merged
      nums1[idx--] = nums1[l--];
    while (r >= 0)  // all elements in nums1 have been merged
      nums1[idx--] = nums2[r--];
  }
}
