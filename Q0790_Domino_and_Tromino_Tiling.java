/**
 * Created by csy99 on 5/1/20.
 */
class Solution {
    public int numTilings(int N) {
        // ways[i]: 0, completely covered col i; 1, only cover one tile in col i
        final int m = 1000000007;
        long[][] ways = new long[N+1][2];
        ways[0][0] = 1;
        ways[1][0] = 1; 
        for (int i = 2; i <= N; i++) {
            ways[i][0] = (ways[i-2][0] + ways[i-1][0] + 2*ways[i-1][1]) % m;
            ways[i][1] = (ways[i-2][0] + ways[i-1][1]) % m;
        }
        return (int)ways[N][0];
    }
}
