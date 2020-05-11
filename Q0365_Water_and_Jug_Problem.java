package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q365_Water_and_Jug_Problem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x == z || y == z || x + y == z)
            return true;
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        if (y == 0) return false;
        return z % gcd(x, y) == 0;
    }
    
    public int gcd(int x, int y){
        while (x % y != 0) {
            int nxt = x % y;
            x = y;
            y = nxt;
        }
        return y;
    }
}
