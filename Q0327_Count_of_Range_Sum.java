package Leetcode;

/**
 * Created by csy99 on 6/9/20.
 */
public class Q327_Count_of_Range_Sum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) return 0;
        long[] sums = new long[n+1];
        for (int i = 1; i <= n; i++)
            sums[i] = sums[i-1] + nums[i-1];
        return mergeSort(sums, 0, n, lower, upper);
    }
    
    private int mergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (start >= end) return 0;
        int mid = (end-start+1) / 2 + start;
        int count = mergeSort(sums, start, mid-1, lower, upper) +
            mergeSort(sums, mid, end, lower, upper);
        int idx1 = mid;
        int idx2 = mid;
        for (int i = start; i < mid; i++) {
            while (idx1 <= end && sums[idx1] - sums[i] < lower)
                idx1++;
            while (idx2 <= end && sums[idx2] - sums[i] <= upper)
                idx2++;
            count += idx2 - idx1;
        }
        merge(sums, start, mid-1, mid, end);
        return count;
    }
    
    private void merge(long[] sums, int lo1, int hi1, int lo2, int hi2) {
        long[] helper = new long[hi2-lo1+1];
        int k = 0;
        int i = lo1, j = lo2;
        while (i <= hi1 && j <= hi2) {
            if (sums[i] <= sums[j])
                helper[k++] = sums[i++];
            else
                helper[k++] = sums[j++];
        }
        while (i <= hi1) 
            helper[k++] = sums[i++];
        while (j <= hi2)
            helper[k++] = sums[j++];
        for (int idx = lo1; idx <= hi2; idx++)
            sums[idx] = helper[idx-lo1];
    }
}
