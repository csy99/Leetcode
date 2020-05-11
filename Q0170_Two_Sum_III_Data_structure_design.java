package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by csy99 on 4/19/20.
 * <p>
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */


public class Q170_Two_Sum_III_Data_structure_design {
    HashMap<Integer, Integer> cnt = new HashMap();
    
    public void add(int number) {
        if (cnt.containsKey(number))
            cnt.put(number, cnt.get(number)+1);       
        else
            cnt.put(number, 1);
    }

    public boolean find(int value) {
        for (Integer key: cnt.keySet()) {
            int second = value - key;
            if (cnt.containsKey(second))
                if (key != second || cnt.get(key) > 1)
                    return true;
        }
        return false;
    }
}
