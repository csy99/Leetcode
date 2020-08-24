package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 8/24/20.
 */
public class Q166_Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && denominator > 0 ||
           numerator > 0 && denominator < 0)
            sb.append("-");
        // must cast to long first, otherwise might overflow 
        long numer = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        sb.append(numer / denom);
        long remainder = numer % denom;
        if (remainder == 0) 
            return sb.toString();
        sb.append(".");
        // record the position of remainder digits
        HashMap<Long, Integer> map = new HashMap();
        while (remainder > 0) {
            if (map.containsKey(remainder)) { // repeating fractional part
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / denom);
            remainder %= denom;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Q166_Fraction_to_Recurring_Decimal sol = new Q166_Fraction_to_Recurring_Decimal();
        String res = sol.fractionToDecimal(-1, -2147483648);
        System.out.println(res);
    }
}
