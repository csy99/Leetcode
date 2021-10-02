/**
 * Created by csy99 on 10/2/21.
 */
class Solution {
    public double[] getCollisionTimes(int[][] A) {
        int n = A.length;
        Stack<Integer> traffic = new Stack();
        double[] res = new double[n];
        for (int i = n - 1; i >= 0; --i) {
            res[i] = -1.0;
            int nxt_dist = A[i][0], nxt_speed = A[i][1];
            while (traffic.size() > 0) {
                int j = traffic.peek(), cur_dist = A[j][0], cur_speed = A[j][1];
                if (nxt_speed <= cur_speed || 
                    1.0 * (nxt_dist - cur_dist) / (cur_speed - nxt_speed) >= res[j] && res[j] > 0)
                    traffic.pop();
                else
                    break;
            }
            if (traffic.size() > 0) {
                int j = traffic.peek(), cur_dist = A[j][0], cur_speed = A[j][1];
                res[i] = 1.0 * (nxt_dist - cur_dist) / (cur_speed - nxt_speed);
            }
            traffic.push(i);
        }
        return res;
    }
}

