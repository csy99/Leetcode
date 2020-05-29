/**
 * Created by csy99 on 5/29/20.
 */
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;
        if (n == 0)
            return 0;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++)
            sum[i+1] = sum[i] + A[i];
        int res = 0;
        HashMap<Integer, Integer> count = new HashMap();
        // looking for number i < j w/ sum[j]-sum[i] == S
        for (int i: sum) {
            res += count.getOrDefault(i, 0);
            // System.out.printf("i:%d res:%d",i,res);
            count.put(i+S, count.getOrDefault(i+S, 0)+1);
            // System.out.printf(" map[%d]=%d\n",i+S,count.get(i+S));
        }
        return res;
    }
}
