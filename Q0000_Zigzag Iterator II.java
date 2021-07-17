/**
 * Created by csy99 on 7/17/21.
 * 
 * A follow up question for LC 281 Zigzag Iterator:
 * What if you are given k 1d vectors? If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
 */
public class ZigzagIterator2 {
    int[] p;
    int K;
    int t = 0;
    List<List<Integer>> l;
    public ZigzagIterator2(List<List<Integer>> vecs) {
        K = vecs.size();
        l = vecs;
        p = new int[K];
    }

    public int next() {
        int res = 0;
        int idx = t % K;
        t++;
        int k = idx;
        do {
            if (p[k] < l.get(k).size()) 
                return l.get(k).get(p[k]++);
            t++;
            k++;
            k %= K;
        } while (k != idx);
        return res;
    }

    public boolean hasNext() {
        for (int k = 0; k < K; k++) {
            if (p[k] < l.get(k).size())
                return true;
        }
        return false;
    }
}
