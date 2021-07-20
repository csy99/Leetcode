package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by csy99 on 7/20/21.
 * <p>
 * Design a Phone Directory which supports the following operations:
 * <p>
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 */
public class Q379_Design_Phone_Directory {
    int max;
    HashSet<Integer> used;
    LinkedList<Integer> queue;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public Q379_Design_Phone_Directory(int maxNumbers) {
        used = new HashSet<Integer>();
        queue = new LinkedList<Integer>();
        for (int i = 0; i < maxNumbers; i++) 
            queue.offer(i);
        max = maxNumbers - 1;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (queue.isEmpty())
            return -1;

        int e = queue.poll();
        used.add(e);
        return e;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !used.contains(number) && number <= max;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (used.contains(number)) {
            used.remove(number);
            queue.offer(number);
        }
    }
}
