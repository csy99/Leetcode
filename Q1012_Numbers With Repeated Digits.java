/**
 * Created by csy99 on 8/25/21.
 */
// count digit by digit, time: O(log n) not taking account of permutation, space: O(1)
class Solution {
    public int numDupDigitsAtMostN(int n) {
        List<Integer> nums = new ArrayList();
        for (int x = n+1; x > 0; x /= 10)
            nums.add(0, x % 10);
        int res = 0;
        int len = nums.size();
        for (int i = 1; i < len; i++)
            res += 9 * P(9, i-1);
        boolean[] seen = new boolean[10];
        for (int i = 0; i < len; i++) {
            int digit = nums.get(i);
            for (int j = i > 0 ? 0 : 1; j < digit; j++)
                if (!seen[j])
                    res += P(9-i, len-i-1);
            if (seen[digit]) break;
            seen[digit] = true;
        }
        return n-res;
    }
    
    private int P(int n, int k) {
        if (k == 0) return 1;
        return P(n, k-1) * (n-k+1);
    }
}
