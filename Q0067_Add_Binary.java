package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 */
public class Q067_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) 
            sb.insert(0, "1");
        return sb.toString();
    }

    public static void main(String[] args) {
        Q067_Add_Binary sol = new Q067_Add_Binary();
        String a = "1010";
        String b = "1011";

        String result = sol.addBinary(a, b);
        System.out.println(result); //10101

    }
}
