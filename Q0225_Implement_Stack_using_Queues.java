package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 3/24/20.
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 */
public class Q225_Implement_Stack_using_Queues {
class MyStack {
    Queue<Integer> q1;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
}
