package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 6/29/20.
 */
public class Q313_Super_Ugly_Number {
    // arrays, time: O(nk), space: O(n)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int k = primes.length;
        int[] idx = new int[k];
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                // skip duplicate
                if (ugly[idx[j]] * primes[j] == ugly[i-1])
                    idx[j]++;
                ugly[i] = Math.min(ugly[i], ugly[idx[j]] * primes[j]);
            }
        }
        return ugly[n-1];
    }
    
    // pq, time: O(n*logk), space: O(n)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int k = primes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for (int i = 0; i < k; i++)
            pq.offer(new int[] {primes[i], primes[i], 0});
        int size = 1;
        while (size < n) {
            int[] entry = pq.poll();
            int num = entry[0];
            int prime = entry[1];
            int index = entry[2];
            if (num != ugly[size-1]) 
                ugly[size++] = num;
            pq.offer(new int[]{prime*ugly[index+1], prime, index+1});
        }
        return ugly[n-1];
    }    
}
