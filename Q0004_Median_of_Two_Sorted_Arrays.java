package Leetcode;

/**
 * Created by csy99 on 3/10/20.
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log(min(m,n))).
 */
public class Q004_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int k = (nums1.length + nums2.length + 1) / 2;
        int l = 0; 
        int r = nums1.length;
        while (l < r) {
            int m1 = l + (r - l) / 2;
            if (nums1[m1] < nums2[k - m1 - 1])
                l = m1 + 1;
            else
                r = m1;
        }
        int m1 = l;
        int m2 = k-l;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], 
                          m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        
        if ((nums1.length + nums2.length) % 2 == 1)
            return c1;
        
        int c2 = Math.min(m1 >= nums1.length ? Integer.MAX_VALUE : nums1[m1], 
                          m2 >= nums2.length ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) / 2.0;
    }
}
