package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 4/12/20.
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class Q380_Insert_Delete_GetRandom_O_1 {
    HashMap<Integer, Integer> map; // map from val to idx in array
    ArrayList<Integer> values;
    Random rand = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap();
        values = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, values.size());
        values.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false; 
        int idx = map.get(val);
        if (idx < values.size()-1) {
            int lastElement = values.get(values.size()-1);
            values.set(idx, lastElement);
            map.put(lastElement, idx);
        }
        map.remove(val);
        values.remove(values.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}
