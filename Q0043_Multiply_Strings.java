package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 */
public class Q043_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty())
            return "0";
        int[] res = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int posLow = i + j + 1;
                int posHigh = i + j;
                mul += res[posLow];
                res[posLow] = mul % 10;
                res[posHigh] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0 || sb.length() > 0)
                sb.append(res[i]);
        }
        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        Q043_Multiply_Strings sol = new Q043_Multiply_Strings();
        String a = "42";
        String b = "32";
        String res = sol.multiply(a,b);
        System.out.println(res);
    }
}
