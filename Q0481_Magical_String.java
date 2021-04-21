package Leetcode;

/**
 * Created by csy99 on 4/21/20.
 */
class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int[] a = new int[n+1];
        a[0]=1;
        a[1]=2;
        a[2]=2;
        int head = 2;
        int tail = 3;
        int num = 1;
        int res = 1;
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1&& tail < n)
                    res++;
                tail++;
            }
            // flip 1 to 2 or the other way round
            num = num ^ 3;
            head++;
        }
        return res;
    }
}
