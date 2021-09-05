/**
 * Created by csy99 on 9/4/21.
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> weights = new LinkedList();
        for (int stone: stones)
            weights.add(stone);
        while (weights.size() > 1) {
            Collections.sort(weights, Collections.reverseOrder());
            int first = weights.remove(0);
            int second = weights.remove(0);
            int diff = first - second;
            if (diff > 0)
                weights.add(diff);
        }
        if (weights.size() == 0) return 0;
        return weights.get(0);
    }
}
