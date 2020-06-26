package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q232_Implement_Queue_using_Stacks {
// pop, peek: amortized O(1), the rest: O(1)
class MyQueue {
    Stack<Integer> add;
    Stack<Integer> store;

    /** Initialize your data structure here. */
    public MyQueue() {
        add = new Stack();
        store = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        add.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!store.isEmpty())
            return store.pop();
        while (!add.isEmpty())
            store.push(add.pop());
        return store.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!store.isEmpty())
            return store.peek();
        while (!add.isEmpty())
            store.push(add.pop());
        return store.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return store.isEmpty() && add.isEmpty();
    }
}
    
// push: O(n), the rest: O(1)
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    private int front;
    
    public MyQueue() {
        st1 = new Stack();
        st2 = new Stack();
        front = -1;
    }
    
    public void push(int x) {
        if (st1.size() == 0)
            front = x;
        while (st1.size() > 0) 
            st2.push(st1.pop());
        st2.push(x);
        while (st2.size() > 0)
            st1.push(st2.pop());
    }
    
    public int pop() {
        int res = st1.pop();
        if (st1.size() > 0)
            front = st1.peek();
        return res;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        if (st1.size() == 0 && st2.size() == 0)
            return true;
        return false;
    }
}
}
