/**
 * Created by csy99 on 7/7/21.
 */
class MyHashSet {
    boolean[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        int n = (int)1e6 + 1;
        arr = new boolean[n];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}
