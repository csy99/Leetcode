package Leetcode;

/**
 * Created by csy99 on 5/19/20.
 */
public class Q480_Sliding_Window_Median {
    // insertion sort, time: O(n*k)
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return new double[0];
        double[] res = new double[n-k+1];
        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = nums[i];
        Arrays.sort(arr);
        for (int i = 0; i < n-k+1; i++) {
            res[i] = getMid(arr);
            if (i == n-k)
                break;
            remove(arr, nums[i]);
            insert(arr, nums[i+k]);
        }
        return res;
    }
    
    private double getMid(int[] arr) {
        if (arr.length % 2 == 1)
            return arr[arr.length/2];
        return ((double)arr[arr.length/2-1] + (double)arr[arr.length/2]) / 2;
    }

    private int getPos(int[] arr, int num) {
        int l = 0; 
        int r = arr.length-1;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == num)
                return mid;
            if (arr[mid] < num)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    
    private void remove(int[] arr, int num) {
        int pos = getPos(arr, num);
        for (int i = pos; i < arr.length-1; i++)
            arr[i] = arr[i+1];
    }

    private void insert(int[] arr, int num) {
        int pos = getPos(arr, num);
        for (int i = arr.length-1; i > pos; i--) 
            arr[i] = arr[i-1];
        arr[pos] = num;
    }
}
