/**
 * Created by csy99 on 11/12/20.
 */
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = (int)1e6;
        while (l < r) {
            int mid = (r - l)/2 + l;
            if (valid(nums, threshold, mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    
    private boolean valid(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int num: nums) 
            sum += (num-1)/divisor+1;
        return sum <= threshold;
    }
}
