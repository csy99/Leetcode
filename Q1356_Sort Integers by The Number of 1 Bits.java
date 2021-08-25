/**
 * Created by csy99 on 8/25/21.
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;
        int high = 0;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int num: arr) {
            int bits = Integer.bitCount(num);
            low = Math.min(low, bits);
            high = Math.max(high, bits);
            List<Integer> cur = map.getOrDefault(bits, new ArrayList());
            cur.add(num);
            map.put(bits, cur);
        }
        int[] res = new int[n];
        int pos = 0;
        for (int b = low; b <= high; b++) {
            List<Integer> cur = map.getOrDefault(b, new ArrayList());
            Collections.sort(cur);
            while (cur.size() > 0) {
                res[pos++] = cur.get(0);
                cur.remove(0);
            }
        }
        return res;
    }
}
