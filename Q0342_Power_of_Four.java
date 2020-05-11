package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q342_Power_of_Four {

    // Square + 3n+1 form
    public boolean isPowerOfFour(int num) {
        return (((num & (num - 1)) == 0) && ((num - 1) % 3 == 0));
    }

    public boolean isPowerOfFour(int num) {
        double a = Math.log(num) / Math.log(4);
        return Math.abs(a - Math.rint(a)) <= 0.00001;
    }
}
