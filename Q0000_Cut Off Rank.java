/**
 * Created by csy99 on 7/31/21.
 */
class Solution {
    public int cutOffRank(int cutOffRank, int num, int[] scores) {
        if(cutOffRank == 0) return 0;
        int res = 0;
        int[] counts = new int[101];
        for (int s : scores)
            counts[s]++;
        for (int i = 100; i > 0; i--){
            if (cutOffRank <= 0) break;
            cutOffRank -= counts[i];
            res += counts[i];
        }    
        return res;
    }
}
