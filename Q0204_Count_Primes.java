package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Q204_Count_Primes {
    // method 1: n = a * b, a <= sqrt(n), time: O(n*(log n)), space: O(1)
    // method 2: 筛子法, time: O(n*(log(log n)), space: O(n)
    public int countPrimes(int n) {
        // attention: less than n (excluding n)
        if (n < 3) return 0;
        // 0: is prime, -1: not prime
        int[] prime = new int[n];
        prime[0] = -1;
        prime[1] = -1;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (prime[(int)i] == -1)
                continue;
            for (long j = i*i; j < n; j += i)   // its multiples are not primes
                prime[(int)j] = -1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (prime[i] == 0)
                cnt++;
        return cnt;
    }
}
