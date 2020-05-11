package Leetcode;

import java.util.List;

/**
 * Created by csy99 on 4/19/20.
 * <p>
 * Implement an iterator to flatten a 2d vector.
 * For example,
 * Given 2d vector =
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class Q251_Flatten_2D_Vector {
    List<List<Integer>> vec = null;
    int i = 0;
    int j = 0;
    
    public Vector2D(List<List<Integer>> vec2d) {
        vec = vec2d;
    }

    @Override
    public Integer next() {
        while (i < vec.size() && j == vec.get(i).size()) {
            i++;
            j = 0;
        }
        int val = vec.get(i).get(j);
        j++;
        return val;
    }

    @Override
    public boolean hasNext() {
        while (i < vec.size() && j == vec.get(i).size()) {
            i++;
            j = 0;
        }
        return i < vec.size();
    }
}
