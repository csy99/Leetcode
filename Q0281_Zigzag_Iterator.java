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
    Iterator<Integer> i;
    Iterator<Integer> j;
    Iterator<Integer> tmp;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            tmp = j;
            j = i;
            i = tmp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
