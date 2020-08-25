package Leetcode;

/**
 * Created by csy99 on 8/25/20.
 */
public class Q403_Frog_Jump {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 3; i < n; i++) {
            if (stones[i] > stones[i-1] * 2)
                return false;
        }
        
        HashSet<Integer> collection = new HashSet();
        for (int stone: stones)
            collection.add(stone);
        Stack<Integer> pos = new Stack();
        pos.add(0);
        Stack<Integer> jump = new Stack();
        jump.add(0);
        while (pos.size() > 0) {
            int p = pos.pop();
            int k = jump.pop();
            for (int d = k-1; d <= k+1; d++) {
                if (d <= 0) continue;
                int nxt = p + d;
                if (nxt == stones[n-1])
                    return true;
                if (collection.contains(nxt)) {
                    pos.push(nxt);
                    jump.push(d);
                }
            }
        }
        return false;
    }
}
