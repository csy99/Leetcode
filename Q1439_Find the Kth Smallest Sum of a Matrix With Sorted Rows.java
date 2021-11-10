/**
 * Created by csy99 on 11/9/21.
 */
// priority queue, time: O(mnk*logk), space: O(k)
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int col = Math.min(n, k);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.add(0);
        for (int[] row: mat) {
            PriorityQueue<Integer> cur = new PriorityQueue(Collections.reverseOrder());
            for (int num: pq) {
                for (int j = 0; j < col; j++) {
                    cur.add(num + row[j]);
                    if (cur.size() > k) 
                        cur.poll();
                }
            }
            pq = cur;
        }
        return pq.poll();
    }
}
