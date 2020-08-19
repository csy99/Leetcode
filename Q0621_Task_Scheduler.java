package Leetcode;

/**
 * Created by csy99 on 8/19/20.
 */
public class Q621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (len == 0) return 0;
        int[] counts = new int[26];
        int longest = 0;
        int num = 1;
        for (char task: tasks) 
            ++counts[task - 'A'];
        for (int count: counts) {
            if (count > longest) {
                longest = count;
                num = 1;
            } else if (count == longest)
                num++;
        }
        int lower_bound = (longest - 1) * (n + 1) + num;
        return Math.max(lower_bound, len);
    }
}
