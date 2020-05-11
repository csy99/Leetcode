class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        if (n <= 1) return 0;
        // swaps[i]: 0, not swapping A[i] and B[i]; 1, otherwise
        int[][] swaps = new int[n][2];
        for (int i = 1; i < n; i++) {
            swaps[i][0] = Integer.MAX_VALUE;
            swaps[i][1] = Integer.MAX_VALUE;
        }
        swaps[0][1] = 1;
        for (int i = 1; i < n; i++) {
            // no swap needed
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                swaps[i][0] = swaps[i-1][0];
                swaps[i][1] = 1 + swaps[i-1][1];
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                swaps[i][0] = Math.min(swaps[i][0], swaps[i-1][1]);
                swaps[i][1] = Math.min(swaps[i][1], swaps[i-1][0] + 1);
            } 
        }
        return Math.min(swaps[n-1][0], swaps[n-1][1]);
    }
}
