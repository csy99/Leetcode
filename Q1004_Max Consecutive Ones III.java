/**
 * Created by csy99 on 7/23/20. 
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int l = 0;
        int r = 0;
        int longest = 0;
        int swap = 0;
        
        while (r < n) {
            if (A[r] == 1 || swap < K) {
                if (A[r] == 0)
                    swap++;
                r++;
                longest = Math.max(r-l, longest);
                continue;
            }
            while (swap >= K) {
                if (A[l] == 0)
                    swap--;
                l++;
            }
        }
        return longest;
    }
}
