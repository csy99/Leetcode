package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q295_Find_Median_from_Data_Stream {
    // this maxHeap is used to store the left half (smaller part) of the stream
  PriorityQueue<Integer> left;
  // this minHeap is used to store the right half (larger part) of the stream
  PriorityQueue<Integer> right;
  
    /** initialize your data structure here. */
    public MedianFinder() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
      if (left.size() == 0 || num <= left.peek()) 
        left.add(num);
      else 
        right.add(num);
       
      // balance two heaps
      if (right.size() > left.size()) 
        left.add(right.poll());
      else if (left.size() - right.size() >= 2)
        right.add(left.poll());
        
    }
    
    public double findMedian() {
      if (left.size() != right.size())  // the total count is odd
        return (double)left.peek();
      return ((double)left.peek()+right.peek())/2;
    }
}
