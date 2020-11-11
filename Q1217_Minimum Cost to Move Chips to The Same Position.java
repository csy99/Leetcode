/**
 * Created by csy99 on 11/11/20.
 */
class Solution {
    public int minCostToMoveChips(int[] position) {
        int even_cnt = 0;
        int odd_cnt = 0;
        for (int p: position) {
            if (p % 2 == 0)
                even_cnt++;
            else
                odd_cnt++;
        }
        return Math.min(odd_cnt, even_cnt);
    }
}
