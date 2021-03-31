/**
 * Created by csy99 on 3/31/21.
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (bits[n-1] != 0) return false;
        if (n == 1) return true;
        int i = n-2;
        while (i >= 0 && bits[i] == 1) {
            i--;
        }
        return (n-i)%2 == 0;
    }
}
