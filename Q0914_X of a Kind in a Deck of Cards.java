/**
 * Created by csy99 on 4/4/21.
 */
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cnt = new HashMap();
        for (int num: deck) 
            cnt.put(num, cnt.getOrDefault(num,0)+1);
        int lowest_freq = deck.length;
        for (Integer key: cnt.keySet()) 
            lowest_freq = Math.min(lowest_freq, cnt.get(key));
        if (lowest_freq == 1) return false;
        List<Integer> freqs = new ArrayList();
        for (int f = 2; f <= lowest_freq/2; f++)
            if (lowest_freq % f == 0)
                freqs.add(f);
        freqs.add(lowest_freq);
        for (int freq: freqs) {
            boolean succ = true; 
            for (Integer key: cnt.keySet()) {
                int val = cnt.get(key);
                if (val % freq != 0) {
                    succ = false;
                    break;
                }
            }
            if (succ) return true;
        }
        
        return false;
    }
}
