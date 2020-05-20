/**
 * Created by csy99 on 5/20/20.
 */
class Solution {
    // merge sort
    public int[] sortArray(int[] nums) {
        if (nums.length == 0) return new int[0];
        return merge(nums, 0, nums.length-1);
    }
    
    private int[] merge(int[] nums, int l, int r) {
        if (l == r)
            return new int[] {nums[l]};
        int mid = l + (r - l) / 2;
        int[] first = merge(nums, l, mid);
        int[] second = merge(nums, mid+1, r);
        int[] merged = new int[r-l+1];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j])
                merged[k++] = first[i++];
            else
                merged[k++] = second[j++];
        }
        while (i < first.length)
            merged[k++] = first[i++];
        while (j < second.length)
            merged[k++] = second[j++];
        return merged;
    }
    
    // insertion sort
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        for (int i = 1; i < nums.length; i++) {
            int j = i-1;
            int tmp = nums[i];
            while (j >= 0 && nums[j] > tmp) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = tmp;
        }
        return nums;
    }
    
    // quick sort
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
    
    private void sort(int[] arr, int l, int r) {
        int p = arr[l+(r-l)/2];
        int i = l;
        int j = r;
        while (i < j) {
            while (arr[i] < p)
                i++;
            while (arr[j] > p)
                j--;
            if (i <= j) {  // important
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if (l < j)
            sort(arr, l, j);
        if (i < r)
            sort(arr, i, r);
    }
}
