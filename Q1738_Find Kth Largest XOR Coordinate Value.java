/**
 * Created by csy99 on 1/24/21.
 */
class Solution {
    public int kthLargestValue(int[][] matrix, int K) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue(m*n, Collections.reverseOrder());
        int[][] copy = new int[m][n];
        copy[0][0] = matrix[0][0];
        pq.add(copy[0][0]);
        for (int j = 1; j < n; j++) {
            copy[0][j] = copy[0][j-1] ^ matrix[0][j];
            pq.add(copy[0][j]);
        }
        for (int i = 1; i < m; i++) {
            copy[i][0] = copy[i-1][0] ^ matrix[i][0];
            pq.add(copy[i][0]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                copy[i][j] = copy[i-1][j] ^ copy[i][j-1] ^ copy[i-1][j-1] ^ matrix[i][j];
                pq.add(copy[i][j]);
            }
        }
        for (int k = 0; k < K-1; k++)
            pq.remove();
        return pq.remove();
    }
}
