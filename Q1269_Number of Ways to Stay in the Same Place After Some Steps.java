/**
 * Created by csy99 on 5/7/20. 
 */
class Solution {
    // dp, time: O(mn), space: O(n)
    // TLE for 2 cases
    public int numWays(int steps, int arrLen) {
        int kMod = 1_000_000_007;
        int[] arr = new int[arrLen];
        arr[0] = 1;
        for (int i = 0; i < steps; i++) {
            int[] cur = new int[arrLen];
            for (int j = 0; j < arrLen; j++) {
                int left = j == 0 ? 0 : arr[j-1];
                int right = j == arrLen-1 ? 0 : arr[j+1];
                cur[j] = (left + right) % kMod;
                cur[j] = (cur[j] + arr[j]) % kMod;
            }
            arr = cur;
        }
        return arr[0] % kMod;
    }
    
    // need a small optimization
    public int numWays(int steps, int arrLen) {
        int kMod = 1_000_000_007;
        int n = Math.min(arrLen, steps);
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 0; i < steps; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                cur[j] = arr[j];
                if (j > 0) 
                    cur[j] = (cur[j] + arr[j-1]) % kMod;
                if (j < n-1)
                    cur[j] = (cur[j] + arr[j + 1]) % kMod;
            }
            arr = cur;
        }
        return arr[0] % kMod;
    }
}
