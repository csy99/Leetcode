package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by csy99 on 5/31/20.
 * <p>
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Q118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        for (int r = 1; r <= numRows; r++) {
            List<Integer> level = new ArrayList();
            for (int i = 0; i < r; i++) {
                if (i == 0 || i == r-1)
                    level.add(1);
                else {
                    List<Integer> prev = res.get(res.size()-1);
                    level.add(prev.get(i-1) + prev.get(i));
                }
            }
            res.add(level);
        }
        return res;
    }
}
