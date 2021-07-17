package Leetcode;

import java.util.List;

/**
 * Created by csy99 on 4/19/20.
 * <p>
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p>
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 */

public class Q281_Zigzag_Iterator {
    int i = 0;
    int j = 0;
    int t = 0;
    List<Integer> l1;
    List<Integer> l2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l1 = v1;
        l2 = v2;
    }

    /*
     * @return: An integer
     */
    public int next() {
        if (i >= l1.size()) 
            return l2.get(j++);
        if (j >= l2.size()) 
            return l1.get(i++);
        int res = 0;
        if (t % 2 == 0)
            res = l1.get(i++);
        else
            res = l2.get(j++);
        t++;
        return res;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        return i < l1.size() || j < l2.size();
    }
}
