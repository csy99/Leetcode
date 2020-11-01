package Leetcode;

/**
 * Created by csy99 on 3/23/20.
 */
public class Q091_Decode_Ways {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (s.charAt(0) == '0') return 0; // check if there is a leading 0
        int pre2 = 1; // ways(i-2)
        int pre = 1; // ways(i-1)
        int cur = 1;
        for (int i = 1; i < n; i++) {
            int twoChar = Integer.parseInt(s.substring(i-1, i+1)); // ending with i
            cur = 0;
            if (s.charAt(i) != '0')
                cur = pre;
            if (twoChar > 9 && twoChar < 27)
                cur += pre2;
            pre2 = pre;
            pre = cur;
        }
        return cur;
    }
}
