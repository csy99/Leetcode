package Leetcode;

/**
 * Created by csy99 on 8/25/20.
 */
public class Q402_Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        // greedy, make seq close to asc order
        while (idx < n && k > 0) {  
            char cur = num.charAt(idx);
            while (sb.length() > 0 && cur - '0' < sb.charAt(sb.length()-1) - '0' && k > 0) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(cur);
            idx++;
        }
        sb.append(num.substring(idx, n));
        // the seq is already in strict asc order, get rid of the last few digit
        sb.setLength(sb.length() - k);
        // deal with leading 0
        while (sb.length() > 1) {
            if (sb.charAt(0) == '0')
                sb.deleteCharAt(0);
            else
                break;
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
