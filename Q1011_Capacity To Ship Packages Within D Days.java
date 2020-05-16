/**
 * Created by csy99 on 5/16/20.
 */
class Solution {
    int[] W;
    public int shipWithinDays(int[] weights, int D) {
        W = weights;
        int l = 1;
        int r = 0;
        for (int i = 0; i < weights.length; i++)
            r += weights[i];
        while (l < r) {
            int mid = l + (r - l)/2;
            if (canLoad(D, mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    
    private boolean canLoad(int deadline, int cap) {
        int days = 1;  // important, at least one day for shipping
        int w = 0;
        int i = 0;
        while (i < W.length) {
            if (w + W[i] <= cap) 
                w += W[i];
            else if (W[i] > cap)  // a package cannot be splitted
                return false;
            else {
                w = W[i];
                days++;
            }
            i++;
        }
        return days <= deadline;   
    }
}
