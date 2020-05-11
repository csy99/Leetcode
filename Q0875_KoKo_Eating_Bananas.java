/**
 * Created by csy99 on 4/24/20. 
 */
class Solution {
  public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        int r = 1000000000;
        while (l < r) {
            int k = (r + l) / 2;
            if (canFinish(piles, H, k))
                r = k;
            else
                l = k + 1;
        }
        return l;
    }
    
    private boolean canFinish(int[] piles, int h, int k) {
        int res = 0;
        for (int i = 0; i < piles.length; i++)
            res += (piles[i] - 1) / k + 1;
        return res <= h;
    }
}
