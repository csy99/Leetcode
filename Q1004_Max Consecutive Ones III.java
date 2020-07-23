/**
 * Created by csy99 on 7/23/20. 
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 0;
        int r = 0;
        int n = A.length;
        int longest = 0;
        int swap = 0;
        
        while (r < n) {
            if (A[r] == 1) {
                r++;
                longest = Math.max(r-l, longest);
            } else if (swap < K) {
                r++;
                swap++;
                longest = Math.max(r-l, longest);
            } else {
                while (swap >= K) {
                    if (A[l] == 0)
                        swap--;
                    l++;
                }
            }
        }
        return longest;
    }
}
