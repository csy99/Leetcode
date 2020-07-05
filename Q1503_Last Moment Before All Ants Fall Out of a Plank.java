/**
 * Created by csy99 on 7/4/20 during contest. 
 */
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int len1 = left.length;
        int len2 = right.length;
        Arrays.sort(left);
        Arrays.sort(right);
        if (len1 == 0 && len2 == 0) return 0;
        if (len1 == 0) return n-right[0];
        if (len2 == 0) return left[len1-1];
        return Math.max(left[len1-1], n-right[0]);
    }
}
