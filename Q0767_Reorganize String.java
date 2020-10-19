/**
 * Created by csy99 on 10/18/20.
 */
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> counts = new HashMap();
        for (char c: S.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0)+1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char cur = maxHeap.remove();
            sb.append(cur);
            char nxt = maxHeap.remove();
            sb.append(nxt);
            counts.put(cur, counts.get(cur)-1);
            counts.put(nxt, counts.get(nxt)-1);
            if (counts.get(cur) > 0)
                maxHeap.add(cur);
            if (counts.get(nxt) > 0)
                maxHeap.add(nxt);
        }
        if (maxHeap.size() > 0) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1)
                return "";
            sb.append(last);
        }
        return sb.toString();
    }
}
