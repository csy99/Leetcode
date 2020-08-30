/**
 * Created by csy99 on 8/30/20.
 */
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        int count = 0;
        for(int i = 0, j = i + m; j < n; i++, j++) {
            if (arr[i] != arr[j])
                count = 0;
            else if (++count == (k - 1) * m)
                return true;
        }
        return false;
    }
}
 
