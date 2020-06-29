package Leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

public class Q341_Flatten_Nested_List_Iterator implements Iterator<Integer> {
    Stack<NestedInteger> st = new Stack();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        prepare(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext())
            return null;
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (st.size() > 0 && !st.peek().isInteger()) {
            List<NestedInteger> list = st.pop().getList();
            prepare(list);
        }
        return !st.isEmpty();
    }
    
    private void prepare(List<NestedInteger> list) {
        for (int i = list.size()-1; i >= 0; i--)
            st.push(list.get(i));
    }
    
    abstract class NestedInteger {
        public abstract boolean isInteger();

        public abstract Integer getInteger();

        public abstract List<NestedInteger> getList();
    }
}
