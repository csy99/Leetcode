package Leetcode;

/**
 * Created by csy99 on 4/12/20.
 */
public class Q381_Insert_Delete_GetRandom_O_1_Duplicates_allowed {

    ArrayList<Integer> lst;
    HashMap<Integer, Set<Integer>> idx;
    Random rand = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        lst = new ArrayList<Integer>();
	    idx = new HashMap<Integer, Set<Integer>>();        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!idx.containsKey(val)) 
            idx.put(val, new LinkedHashSet<Integer>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0) 
            return false;
	    int remove_idx = idx.get(val).iterator().next();
        idx.get(val).remove(remove_idx);
        int last = lst.get(lst.size() - 1);
        lst.set(remove_idx, last);
        idx.get(last).add(remove_idx);
        idx.get(last).remove(lst.size() - 1);
	    lst.remove(lst.size() - 1);
        return true;        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));        
    }
}


class RandomizedCollection {

    HashMap<Integer, List<Integer>> map = new HashMap();
    ArrayList<Entry> values = new ArrayList();
    Random rand = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        List<Integer> indices = map.getOrDefault(val, new ArrayList<Integer>());
        indices.add(values.size());
        map.put(val, indices);
        values.add(new Entry(val, indices.size()-1));
        return indices.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0)
            return false;
        List<Integer> indices = map.get(val);
        int idx_to_evict = indices.get(indices.size()-1);
        Entry last_entry = values.get(values.size()-1);
        // update index
        map.get(last_entry.value).set(last_entry.idx, idx_to_evict);
        // swap values in arrayList
        values.set(idx_to_evict, last_entry);
        // remove
        values.remove(values.size()-1);
        indices.remove(indices.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int idx = rand.nextInt(values.size());
        return values.get(idx).value;
    }
}

class Entry {
    public int value;
    public int idx;
    public Entry(int v, int i) {
        value = v;
        idx = i;
    }
}
