/**
 * Created by csy99 on 11/25/22.
 */
// dp
// time: O(n^2), space: O(n)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int kmod = (int)1e9 + 7;
        long res = 0;
        int[] rangeMin = new int[n];
        for (int i = 0; i < n; i++) {
            rangeMin[i] = arr[i];
            res += arr[i];
            res %= kmod;
        }
        for (int len = 2; len <= n; len++){
            for (int i = 0; i < n-len+1; i++) {
                int j = i + len - 1;
                rangeMin[i] = Math.min(rangeMin[i], arr[j]);
                res += rangeMin[i];
                res %= kmod;
            } 
        }
        return (int) res;
    }
}

// dp + monotonic stack
// time: O(n), space: O(n)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int kmod = (int)1e9 + 7;
        long res = 0;
        int[] rangeMin = new int[n];
        Stack<Integer> st = new Stack();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[i] <= arr[st.peek()])
                st.pop();
            if (st.size() > 0) {
                int prevSmallerIdx = st.peek();
                rangeMin[i] = rangeMin[prevSmallerIdx] + (i - prevSmallerIdx) * arr[i];
            } else {
                rangeMin[i] = (i + 1) * arr[i];
            }
            st.push(i);
        }
        for (int num: rangeMin){
            res += num;
            res %= kmod;
        }
        return (int) res;
    }
}
