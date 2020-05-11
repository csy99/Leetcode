package Leetcode;

import java.util.List;

/**
 * Created by csy99 on 3/24/20.
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

public class Q385_Mini_Parser {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));
        
        Stack<NestedInteger> st = new Stack();
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                st.push(new NestedInteger());
            } else if (Character.isDigit(c) || c == '-') {
                int start = i;
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-'))
                    i++;
                num = Integer.parseInt(s.substring(start, i));
                st.peek().add(new NestedInteger(num));                
                i--;
            } else if (c == ']') {
                NestedInteger ni = st.pop();
                if (!st.isEmpty())
                    st.peek().add(ni);
                else
                    st.push(ni);
            }
            i++;
        }
        return st.pop();
    }

    class NestedInteger {

        public NestedInteger() {

        }

        public NestedInteger(int value) {

        }

        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 1;
        }

        public void setInteger(int value) {

        }

        public void add(NestedInteger ni) {

        }

        public List<NestedInteger> getList() {
            return null;
        }
    }
}





