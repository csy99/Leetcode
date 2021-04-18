package Leetcode;

/**
 * Created by csy99 on 5/20/20.
 */
public class Q493_Reverse_Pairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return 0;
        int mid = l + (r - l) / 2;
        int res = 0;
        res += mergeSort(nums, l, mid);
        res += mergeSort(nums, mid+1, r);
        res += merge(nums, l, mid, r);
        return res;
    }
    
    private int merge(int[] nums, int l, int mid, int r) {
        int cnt = 0;
        int[] arr = new int[r-l+1];
        int p = l;
        int q = mid+1;
        while (p <= mid && q <= r) {
            if ((long)nums[p] > 2*(long)nums[q]) {
                cnt += mid-p+1;
                q++;
            } else
                p++;
        }
        p = l;
        q = mid+1;
        int k = 0;
        while (p <= mid && q <= r) {
            if (nums[p] <= nums[q])
                arr[k++] = nums[p++];
            else
                arr[k++] = nums[q++];
        }
        while (p <= mid)
            arr[k++] = nums[p++];
        while (q <= r)
            arr[k++] = nums[q++];
        k = 0;
        for (int i = l; i < r+1; i++)
            nums[i] = arr[k++];
        return cnt;
    }
}
