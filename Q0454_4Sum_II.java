package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 9/1/20.
 * <p>
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that
 * A[i] + B[j] + C[k] + D[l] is zero.
 */
public class Q454_4Sum_II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;
        for (int x: A)
            for (int y: B) {
                int sum = x+y;
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        for (int x: C)
            for (int y: D) {
                int sum = x+y;
                res += map.getOrDefault(-sum, 0);
            }
        return res;
    }
}
