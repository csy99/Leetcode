/**
 * Created by csy99 on 1/2/21 during contest. 
 */
class Solution {
    long[] sum;
    int n;
    public int waysToSplit(int[] nums) {
        n = nums.length;
        int kmod = (int) 1e9 + 7;
        long res = 0;
        sum = new long[n+1];
        for (int i = 0; i < n; i++)
            sum[i+1] = sum[i] + nums[i];
        for (int i = 1; i < n-1; i++) {
            int l = i+1;
            int r = n-1;
            int lo = 0;
            int hi = 0;
            while (l < r) {  // lower bound
                int mid = l + (r - l) / 2;
                if (valid1(i, mid))
                    r = mid;
                else
                    l = mid+1;
            }
            if (valid1(i, l))
                lo = l;
            else
                continue;
            
            r = n-1;
            while (l < r) {  // upper bound 
                int mid = l + (r - l) / 2;
                if (valid1(i, mid) && valid2(i, mid))
                    l = mid+1;
                else
                    r = mid;
            }
            if (valid1(i, l) && valid2(i, l))
                hi = l;
            else
                hi = l - 1;
            
            res += hi - lo + 1;
            res %= kmod;
        }
        return (int) (res % kmod);
    }
    
    private boolean valid1(int i, int j) {
        return 2*sum[i] <= sum[j];
    }
    
    private boolean valid2(int i, int j) {
        return sum[j] <= (sum[n]-sum[j]+sum[i]);
    }
}
