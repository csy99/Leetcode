package Leetcode;

public class Q554_Brick_Wall {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> cnt = new HashMap();
        for (List<Integer> row: wall) {
            int pos = 0;
            for (int i = 0; i < row.size()-1; i++) {
                pos += row.get(i);
                cnt.put(pos, cnt.getOrDefault(pos,0)+1);
            }
        }
        int best = 0;
        for (int key: cnt.keySet())
            best = Math.max(best, cnt.get(key));
        return n-best;
    }
}
