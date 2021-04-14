package Leetcode;

/**
 * Created by csy99 on 4/14/21.
 */
class Solution {
    // time: O(n!), space: O(n)
    int cnt = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        helper(n, 1, visited);
        return cnt;
    }
    
    private void helper(int n, int pos, boolean[] visited) {
        if (pos > n) {
            cnt++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                helper(n, pos+1, visited);
                visited[i] = false;
            }
        }
    }
}
