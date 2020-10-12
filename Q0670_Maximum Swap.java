/**
 * Created by csy99 on 8/19/20.
 */
class Solution {
    public int maximumSwap(int num) {
        if (num < 10)
            return num;
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        int n = sb.length();
        int[] lastIdx = new int[10];
        for (int i = 0; i < n; i++)
            lastIdx[sb.charAt(i) - '0'] = i;
        for (int i = 0; i < n; i++) {
            for (int d = 9; d >= 0; d--) {
                int cur = sb.charAt(i) - '0';
                if (d > cur && lastIdx[d] > i) {
                    swap(sb, i, lastIdx[d]);
                    return Integer.parseInt(sb.toString());
                }
            }
        }
        return num;
    }
    
    private void swap(StringBuilder sb, int i, int j) {
        char c1 = sb.charAt(i);
        char c2 = sb.charAt(j);
        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);
    }
}

class Solution {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] larger = new int[n];
        for (int i = 0; i < n; i++)
            larger[i] = -1;
        for (int i = n-2; i >= 0; i--) {
            int nxt = Integer.parseInt(str.substring(i+1, i+2));
            if (larger[i+1] < 0 || Integer.parseInt(str.substring(larger[i+1], larger[i+1]+1)) < nxt) 
                larger[i] = i+1;
            else
                larger[i] = larger[i+1];
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            if (larger[i] < 0) continue;
            char candidate = str.charAt(larger[i]);
            char cur = str.charAt(i);
            if (candidate > cur) {
                sb.setCharAt(i, candidate);
                sb.setCharAt(larger[i], cur);
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
