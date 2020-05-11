package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 * <p>
 * Your task is to calculate ab mod 1337
 * where a is a positive integer
 * and b is an extremely large positive integer given in the form of an array.
 */
public class Q372_Super_Pow {
    private static final int NUM = 1337;
    
    public int superPow(int a, int[] b) {
        a = a % NUM;
        int res = 1;
        for (int i = 0; i < b.length; i++) 
            res = ((pow(res, 10) * pow(a, b[i])) % NUM);
        return res;
    }
    
    private int pow(int a, int b) {
        if (b == 0)
            return 1;
        if (b == 1)
            return a;
        int x = pow(a, b/2);
        x = (x * x) % NUM;
        if ((b & 1) == 1)
            x = (x * a) % NUM;
        return x;
    }
}
