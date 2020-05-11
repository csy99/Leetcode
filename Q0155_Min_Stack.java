package Leetcode;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q155_Min_Stack {
// 2 stacks
class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;
    
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack();
        min = new Stack();
    }
    
    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || min.peek() > x)
            min.push(x);
        else
            min.push(min.peek());
    }
    
    public void pop() {
        data.pop();
        min.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
    
    
}
