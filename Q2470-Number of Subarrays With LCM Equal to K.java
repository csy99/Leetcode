/**
 * Created by csy99 on 11/14/22.
 */
// lcm and gcd
// time: O(n^2), space: O(1)
class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int common_multiple = 1;
            for (int j = i; j < n && common_multiple <= k; j++) {
                common_multiple = lcm(common_multiple, nums[j]);
                res += (common_multiple == k) ? 1 : 0;
            }
        }
        return res;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
}
