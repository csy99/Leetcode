/**
 * Created by csy99 on 9/10/21.
 */
class Solution {
    // two pointers, time: O(m log m + n log n), space: O(1)
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)->(a[0]-b[0]));
        Arrays.sort(slots2, (a,b)->(a[0]-b[0]));
        int[][][] total = new int[2][][];
        total[0] = slots1;
        total[1] = slots2;
        int[] pointers = new int[2];
        List<Integer> res = new ArrayList();
        while (true) {
            boolean flag = false;
            for (int p = 0; p < pointers.length; p++) {
                if (pointers[p] >= total[p].length) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            int start = 0;
            int end = Integer.MAX_VALUE;
            int idx = -1;
            for (int p = 0; p < pointers.length; p++) {
                start = Math.max(start, total[p][pointers[p]][0]);
                if (total[p][pointers[p]][1] < end) {
                    end = total[p][pointers[p]][1];
                    idx = p;
                }
            }
            if (end - start >= duration) {
                res.add(start);
                res.add(start+duration);
                return res;
            }
            pointers[idx]++;
        }
        return res;
    }
}
