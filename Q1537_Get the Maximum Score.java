/**
 * Created by csy99 on 8/1/20 during contest.
 */

class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int kmod = (int)1e9+7;
        int m = nums1.length;
        int n = nums2.length;
        long sum1 = 0;
        long sum2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int p = 0, q = 0;
        while (p < m && q < n) {
            if (nums1[p] < nums2[q]) {
                if (sum1 + nums1[p] >= kmod)
                    cnt1++;
                sum1 = (sum1 + nums1[p]) % kmod;
                p++;
            } else if (nums1[p] > nums2[q]) {
                if (sum2 + nums2[q] >= kmod)
                    cnt2++;
                sum2 = (sum2 + nums2[q]) % kmod;
                q++;
            } else {  // can swap
                if (cnt1 > cnt2 || cnt1 == cnt2 && sum1 > sum2) {  // sum of nums1 is larger
                    sum2 = sum1;
                    cnt2 = cnt1;
                } else {
                    sum1 = sum2;
                    cnt1 = cnt2;
                }
                if (sum1 + nums1[p] >= kmod) {
                    cnt1++;
                    cnt2++;
                }
                sum1 = (sum1 + nums1[p]) % kmod;
                p++;
                sum2 = (sum2 + nums2[q]) % kmod;
                q++;
            }
        }
        while (p < m) {
            if (sum1 + nums1[p] >= kmod)
                cnt1++;
            sum1 = (sum1 + nums1[p]) % kmod;
            p++;            
        }
        while (q < n) {
            if (sum2 + nums2[q] >= kmod)
                cnt2++;
            sum2 = (sum2 + nums2[q]) % kmod;
            q++;            
        }
        if (cnt1 > cnt2 || cnt1 == cnt2 && sum1 > sum2)   // sum of nums1 is larger
            return (int)sum1;
        else
            return (int)sum2;
    }
    
}
