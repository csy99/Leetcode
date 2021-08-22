/**
 * Created by csy99 on 8/22/21.
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int k) {
        int n = flowerbed.length;
        for (int i = 0; i < n; i++) {
            if (k == 0) break;
            if (flowerbed[i] == 1) continue;
            if ((i == 0 || flowerbed[i-1] == 0) && 
                (i == n-1 || flowerbed[i+1] == 0)) {
                k--;
                i++;
            }
        }
        return k == 0;
    }
}
