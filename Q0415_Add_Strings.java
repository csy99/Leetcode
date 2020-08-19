package Leetcode;

/**
 * Created by csy99 on 8/18/20.
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int p1 = m-1;
        int p2 = n-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int a = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int b = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int sum = a + b + carry;
            sb.insert(0, (sum%10));
            carry = sum / 10;
            p1--;
            p2--;
        }
        if (carry > 0)
            sb.insert(0, 1);
        return sb.toString();
    }
}
