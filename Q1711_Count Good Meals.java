/**
 * Created by csy99 on 1/3/21.
 */
class Solution {
    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length;
        int kmod = (int)1e9 + 7;
        long res = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int num: deliciousness) {
            int power = 1;
            for (int i = 0; i < 22; i++) {  // num < 2^20
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= kmod;
                }
                power <<= 1;
            }
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return (int) res;
    }
    
}
