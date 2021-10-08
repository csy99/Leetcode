/**
 * Created by csy99 on 10/7/21.
 */
// two pq, time: O(m * log m), space: O(m+n)
class Solution {
    public int[] assignTasks(int[] weights, int[] durations) {
        int m = weights.length;
        int n = durations.length;
        int[] res = new int[n];
        PriorityQueue<Server> free_servers = new PriorityQueue();
        PriorityQueue<Server> used_servers = new PriorityQueue(new Comparator<Server>() {
            public int compare(Server a, Server b) {
                return a.compareToUsed(b);
            }
        });
        for (int i = 0; i < m; i++)
            free_servers.add(new Server(i, weights[i]));
        for (int j = 0; j < n; j++) {
            int ts = j;
            int duration = durations[j];
            Server first = null;
            while (used_servers.size() > 0 && used_servers.peek().available(ts))
                free_servers.add(used_servers.poll());
            if (free_servers.size() == 0) {  // no available server right now
                first = used_servers.poll();
                ts = first.free;
            } else {
                first = free_servers.poll();
            }
            res[j] = first.idx;
            first.assign(new Task(j, duration), ts);
            used_servers.add(first);
        }
        return res;
    }
}

class Task {
    int id;
    int duration;
    
    public Task(int i, int d) {
        id = i;
        duration = d;
    }
}

class Server implements Comparable<Server>{
    int idx;
    int weight;
    int free;
    
    public Server(int i, int w) {
        idx = i;
        weight = w; 
        free = 0;
    }
    
    public void assign(Task task, int ts) {
        free = ts + task.duration;
    }
    
    public boolean available(int ts) {
        return ts >= free;
    }
    
    public int compareTo(Server o) {
        int weight_cmp = Integer.compare(weight, o.weight);
        if (weight_cmp != 0) return weight_cmp;
        return Integer.compare(idx, o.idx);
    }
    
    public int compareToUsed(Server o) {
        int ending = Integer.compare(free, o.free); 
        if (ending != 0)  
            return ending;
        return this.compareTo(o);
    }
}
