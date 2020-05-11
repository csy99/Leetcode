package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q232_Implement_Queue_using_Stacks {
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
        if (store.isEmpty()) {
            while (!add.isEmpty())
                store.push(add.pop());
        }
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
}
