/**
 * Created by csy99 on 8/21/20.
 *
 * arr contains only distinct value.
 * 1 <= k <= n <= 100
 * 1 <= arr[i] <= 1000
 */
class Solution { 
    public int[] largestSubarrayLengthK(int[] arr, int k) {
        int n = arr.length;
        if (n < k)
            return null;
        int largest = 0;
        int idx = -1;
        int[] res =  new int[k];
        for (int i = 0; i+k < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
                idx = i;
            }
        }
        for (i = 0; i < k; i++)
            res[i] = arr[idx+i];
        return res;
    }
}
