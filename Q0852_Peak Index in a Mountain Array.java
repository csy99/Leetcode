/**
 * Created by csy99 on 5/16/20.
 */
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (A[mid] < A[mid+1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
