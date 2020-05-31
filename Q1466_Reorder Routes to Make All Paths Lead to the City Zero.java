/**
 * Created by csy99 on 5/30/20 during contest. 
 */
class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean[] reach = new boolean[n];
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            int[] conn = connections[i];
            if (conn[0] == 0 || reach[conn[0]] == true) {
                res++;
                reach[conn[1]] = true;
            }
            reach[conn[0]] = true;
        }
        return res;
    }
}
