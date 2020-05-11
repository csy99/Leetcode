package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by csy99 on 4/19/20.
 * <p>
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 */

public class Q346_Moving_Average_from_Data_Stream {
    int size;
    Queue<Integer> q;
    double sum;
    /*
    * @param size: An integer
    */
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList();
        sum = 0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        if (q.size() == size) 
            sum -= q.remove();
        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}
