// PriorityQueue
// time: O(k*candidates*log candidates), space: O( Min(k+candidates, n) )
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long res = 0;
        if (k >= n) {
            for (int i = 0; i < n; i++)
                res += costs[i];
            return res;
        }
        
        int count = 0;
        int lowest = Integer.MAX_VALUE;
        int front_idx = candidates-1;
        int back_idx = -1;
        PriorityQueue<Integer> front = new PriorityQueue();
        PriorityQueue<Integer> back = new PriorityQueue();
        
        for (int i = 0; i < candidates; i++) {
            front.add(costs[i]);
        }
        for (int i = 0; i < candidates; i++) {
            back_idx = n - 1 - i;
            if (back_idx <= front_idx) break;
            back.add(costs[n-1-i]);
        }
        while (count < k) {
            int front_num = front.isEmpty() ? Integer.MAX_VALUE : front.peek();
            int back_num = back.isEmpty() ? Integer.MAX_VALUE : back.peek();
            if (front_num <= back_num) {
                res += front.poll();
                if (front_idx + 1 < back_idx) {
                    front_idx += 1;
                    front.add(costs[front_idx]);
                }
            } else {
                res += back.poll();
                if (front_idx + 1 < back_idx) {
                    back_idx -= 1;
                    back.add(costs[back_idx]);
                }
            }
            // System.out.println(res);
            count++;
        }
        
        return res;
    }
}
