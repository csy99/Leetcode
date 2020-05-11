package Leetcode;

import java.util.Iterator;

/**
 * Created by csy99 on 4/19/20.
 */
public class Q284_Peeking_Iterator implements Iterator<Integer> {
    Iterator<Integer> it = null;
    Integer val = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    it = iterator;
	    if (it.hasNext())
            val = it.next();            
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return val;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int res = val;
        if (it.hasNext())
            val = it.next();
        else
            val = null;
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return val != null; 
	}
}
