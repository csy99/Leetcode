/**
 * Created by csy99 on 8/1/20 during contest. 
 */
 
 class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int res = -1;
        if (k >= n) {
            for (int num: arr)
                res = Math.max(res, num);
            return res;
        }
        boolean first = true;
        for (int j = 1; j <= k; j++) {
            if (arr[0] < arr[j]) {
                first = false;
                break;
            }
        }
        if (first) return arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1]) continue;
            boolean flag = true;
            for (int j = 1; j <= k-1; j++) {
                int oppo = i+j < n ? i+j : i+j-n;
                if (arr[i] < arr[oppo]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return arr[i];
        }
        return arr[0];
    }
}
