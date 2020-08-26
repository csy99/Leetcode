package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 8/26/20.
 */
public class Q232_Implement_Queue_using_One_Stack {
    Stack<Integer> s1 = new Stack<Integer>();

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int top = s1.pop();
        if (s1.isEmpty())
            return top;

        int result = pop();
        s1.push(top);
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int top = s1.pop();
        if (s1.isEmpty()) {
            s1.push(top);
            return top;
        }

        int result = peek();
        s1.push(top);
        return result;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
