/**
 * Created by csy99 on 11/26/22.
 */
 
// TreeMap
// time: O(n*log n), space: O(n)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) 
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        Arrays.sort(jobs, new Comparator<Job>(){
            public int compare(Job a, Job b) {
                return Integer.compare(a.end, b.end);
            }
        });
        
        TreeMap<Integer, Integer> maxProfit = new TreeMap();
        for (int i = 0; i < n; i++) {
            Job cur = jobs[i];
            int s = cur.start;
            int e = cur.end;
            
            Integer before_start_key = maxProfit.floorKey(s);
            int curProfit = before_start_key == null ? 0 : maxProfit.get(before_start_key);
            curProfit += cur.profit;
            
            Integer before_end_key = maxProfit.floorKey(e);
            if (before_end_key == null || (before_end_key != null && maxProfit.get(before_end_key) < curProfit) ) {
                maxProfit.put(e, curProfit);
            }
        }
        int latest = jobs[n-1].end;
        int latest_key = maxProfit.floorKey(latest);
        return maxProfit.get(latest_key);
    }
}

class Job {
    int start;
    int end;
    int profit;
    
    public Job(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }
}

// dp, TLE
// time: O(n*log n + n*len), space: O(n)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) 
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        
        Arrays.sort(startTime);
        int earliest = startTime[0];
        Arrays.sort(endTime);
        int latest = endTime[n-1];
        int len = latest-earliest+1;
        int[] maxProfit = new int[len];
        Arrays.sort(jobs, new Comparator<Job>(){
            public int compare(Job a, Job b) {
                return Integer.compare(a.end, b.end);
            }
        });
        
        for (int i = 0; i < n; i++) {
            Job cur = jobs[i];
            int s = cur.start;
            int e = cur.end;
            for (int t = e; t <= latest; t++) {
                maxProfit[t-earliest] = Math.max(maxProfit[t-earliest], maxProfit[s-earliest]+cur.profit);
            }
        }
        return maxProfit[len-1];
    }
}

class Job {
    int start;
    int end;
    int profit;
    
    public Job(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }
}
 
// Greedy profit-time ratio, not correct
