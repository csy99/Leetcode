package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q306_Additive_Number {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i <= (len-1)/2; i++) {  // i is the length of first number
            if (num.charAt(0) == '0' && i > 1)
                break;
            for (int j = i+1; len-j >= j-i && len-j >= i; j++) {  // j - i is the len of second num
                if (num.charAt(i) == '0' && j-i > 1)
                    break;
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                String remaining = num.substring(j);
                if (isAdditive(remaining, num1, num2))
                    return true;
            }
        }
        return false;
    }
  
    private boolean isAdditive(String cur, long num1, long num2) {
        if(cur.equals(""))
            return true;
        long sum = num1 + num2;
        String s = String.valueOf(sum);
        if (!cur.startsWith(s))
            return false;
        return isAdditive(cur.substring(s.length()), num2, sum);
    }
}
