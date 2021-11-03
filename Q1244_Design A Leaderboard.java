/**
 * Created by csy99 on 11/3/21.
 */
class Leaderboard {
    Map<Integer, Integer> scores = new HashMap();
    PriorityQueue<Integer> pq = new PriorityQueue();

    public Leaderboard() {

    }
    
    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        pq.clear();
        for (int val: scores.values()) {
            pq.add(val);
            if (pq.size() > K) pq.poll();
        }
        int sum = 0;
        for (int score: pq)
            sum += score;
        return sum;
    }
    
    public void reset(int playerId) {
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
