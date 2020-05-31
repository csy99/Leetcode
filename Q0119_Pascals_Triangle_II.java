package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 5/31/20.
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 */
public class Q119_Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList();
        last.add(1);
        for (int r = 1; r <= rowIndex; r++) {
            List<Integer> cur = new ArrayList();
            for (int i = 0; i <= r; i++) {
                if (i == 0 || i == r)
                    cur.add(1);
                else
                    cur.add(last.get(i-1) + last.get(i));
            }
            last = cur;
        }
        return last;
    }
}
