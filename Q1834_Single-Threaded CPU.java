/**
 * Created by csy99 on 10/9/21.
 */
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        if (n == 0) return res;
        Task[] sorted = new Task[n];
        for (int i = 0; i < n; i++)
            sorted[i] = new Task(i, tasks[i][0], tasks[i][1]);
        Arrays.sort(sorted, (a,b)->(a.start-b.start));
        PriorityQueue<Task> pq = new PriorityQueue();
        int cur = 0;
        int i = 0;
        for (int seq = 0; seq < n; seq++) {
            while (true) {
                while (i < n && sorted[i].start <= cur) {
                    pq.add(sorted[i]);
                    i++;
                }
                if (pq.size() > 0) break;
                cur = sorted[i].start;
            }
            Task first = pq.poll();
            res[seq] = first.idx;
            cur += first.length;
        }
        return res;
    }
}

class Task implements Comparable<Task>{
    int idx;
    int start;
    int length;
    
    
    public Task(int i, int s, int l) {
        idx = i;
        start = s;
        length = l;
    }
    
    public int compareTo(Task o) {
        int diff_len = Integer.compare(length, o.length);
        if (diff_len != 0) return diff_len;
        return Integer.compare(idx, o.idx);
    }
}
