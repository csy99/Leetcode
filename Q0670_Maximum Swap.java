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
