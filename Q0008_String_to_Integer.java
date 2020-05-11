package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 */
public class Q008_String_to_Integer {
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.isEmpty()) return 0;
        int sign = 1;
        int idx = 0;
        long res = 0;
        if (str.charAt(0) == '+')
            idx++;
        else if (str.charAt(0) == '-') {
            idx++;
            sign = -1;
        }
        for (int i = idx; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                break;
            res = res * 10 + (str.charAt(i) - '0');
            if (res > Integer.MAX_VALUE) {
                if (sign == 1) 
                    return Integer.MAX_VALUE;
                else    
                    return Integer.MIN_VALUE;
            }
        }
        return (int)(sign * res);
    }
}
