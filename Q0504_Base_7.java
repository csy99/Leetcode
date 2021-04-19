package Leetcode;

/**
 * Created by csy99 on 4/18/21.
 */
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int cur = num % 7;
            num /= 7;
            sb.insert(0, cur);
        }
        if (neg)
            sb.insert(0, "-");
        return sb.toString();
    }
}
