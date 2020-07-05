/**
 * Created by csy99 on 7/5/20.
 */
class Solution {
    // time: O(m^2*n), space: O(n)
    // count number of all 1 submetrics for one dim array
    private int countRow(int[] arr) {
        int res = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            len = arr[i] == 0 ? 0 : len + 1;
            res += len;
        }
        return res;
    }
    
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for (int top = 0; top < m; top++) {
            // compressed[j] = 1 means all values in column j from top to bot are one
            int[] compressed = new int[n];
            Arrays.fill(compressed, 1);
            for (int bot = top; bot < m; bot++) {
                for (int j = 0; j < n; j++)
                    compressed[j] &= mat[bot][j];
                res += countRow(compressed);
            }
        }
        return res;
    }
    
    // stack, time: O(m*n), space: O(n)
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                height[j] = mat[i][j] == 0? 0 : height[j] + 1;
            res += helper(height);
        }
        return res;
    }
    
    private int helper(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n];
        Stack<Integer> st = new Stack();
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();
            if (st.size() > 0) {
                int preIdx = st.peek();
                sum[i] = sum[preIdx];
                sum[i] += arr[i] * (i - preIdx);
            } else
                sum[i] = arr[i] * (i + 1);
            st.push(i);
        }
        int res = 0;
        for (int s: sum)
            res += s;
        return res;
    }
}
