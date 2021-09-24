/**
 * Created by csy99 on 9/23/21.
 */
 public class Solution {
    public static int numSplitSmallestDiff(int num) {
        int res = Integer.MAX_VALUE;
        String str = String.valueOf(num);
        int n = str.length();
        for (int i = 1; i < n; i++) {
            String left = str.substring(0, i);
            if (left.charAt(0) == '0' && left.length() > 1)
                continue;
            int l = Integer.parseInt(left);
            String right = str.substring(i);
            if (right.charAt(0) == '0' && right.length() > 1)
                continue;
            int r = Integer.parseInt(right);
            res = Math.min(res, Math.abs(l - r));
        }
        return res;
    }
}
