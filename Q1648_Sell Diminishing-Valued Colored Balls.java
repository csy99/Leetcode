/**
 * Created by csy99 on 9/19/21.
 */
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        final int kmod = (int)1e9+7;
        Arrays.sort(inventory);
        long res = 0;
        int n = inventory.length;
        int i = n-1;
        long count = 1;
        while(orders > 0){
            if(i > 0 && inventory[i] - inventory[i-1] > 0 && orders >= count * (inventory[i] - inventory[i-1])){
                res += count * sumRange(inventory[i-1], inventory[i]);
                orders -= count * (inventory[i] - inventory[i-1]);
            }else if(i == 0 || inventory[i] - inventory[i-1] > 0){
                long quotient = orders / count;
                long remainder = orders % count;
                res += count * sumRange(inventory[i]-quotient, inventory[i]);
                res += remainder * (inventory[i]-quotient);
                orders = 0;
            }
            res %= kmod;
            i--;
            count ++;
        }
        return (int)res;
    }
    
    // (lo, hi]
    private long sumRange(long lo, long hi) {
        return (hi * (hi+1))/2 - (lo * (lo+1))/2;
    }
}
