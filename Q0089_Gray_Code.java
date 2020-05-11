package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 4/17/20.
 */
public class Q089_Gray_Code {
    // bit manipulation
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < 1 << n; i++)
            res.add(i ^ i >> 1);
        return res;
    }
    
    // dp, time: O(2^n), space: O(2^n)
    public List<Integer> grayCode(int n) {
        List<Integer>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList();
        dp[0].add(0);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList(dp[i-1]);
            for (int j = dp[i-1].size() - 1; j >= 0; j--) {
                dp[i].add(dp[i-1].get(j) | (1 << i-1));    
            }
        }
        return dp[n];
    }
    
    // dp, time: O(2^n), space: O(2^n)    
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        res.add(0);
        if (n == 0) return res;
        for (int i = 1; i <= n; i++) {
            List<Integer> cur = new ArrayList(res);
            for (int j = res.size() - 1; j >= 0; j--) {
                cur.add(res.get(j) | (1 << i-1));    
            }
            res = cur;
        }
        return res;
    }
}
