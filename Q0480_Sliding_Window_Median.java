package Leetcode;

/**
 * Created by csy99 on 5/19/20.
 */
public class Q480_Sliding_Window_Median {
    // insertion sort, time: O(n*k)
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k <= 0)
            return new double[0];
        double[] res = new double[nums.length-k+1];
        int[] window = new int[k];
        for (int i = 0; i < k; i++)
            window[i] = nums[i];
        Arrays.sort(window);
        for (int i = k; i <= nums.length; i++) {
            res[i-k] = ((double)window[k/2] + window[(k-1)/2])/2;
            if (i == nums.length)
                break;
            remove(window, nums[i-k]);
            insert(window, nums[i]);
        }
        return res;
    }
    
    private void insert(int[] arr, int val) {
        int i = 0;
        while (i < arr.length-1 && val > arr[i])
            i++;
        int j = arr.length-1;
        while (j > i)
            arr[j] = arr[--j];
        arr[j] = val;
    }
    
    private void remove(int[] arr, int val) {
        int i = 0;
        while (i < arr.length && arr[i] != val)
            i++;
        while (i < arr.length-1) {
            arr[i] = arr[i+1];
            i++;
        }
    }
}
