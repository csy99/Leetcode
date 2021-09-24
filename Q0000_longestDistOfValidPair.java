/**
 * Created by csy99 on 9/23/21.
 */
class Solution {

    public static int longestDistOfValidPair(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int lo = nums[i] - i;
            int hi = nums[i] + i;
            if (map.containsKey(lo))
                res = Math.max(res, i - map.get(lo));
            else
                map.put(lo, i);
            if (map.containsKey(hi))
                res = Math.max(res, i - map.get(hi));
            else
                map.put(hi, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][] {{2, 2, 2, 1}, {2, 4, 6, 7, 4, 7, 2}, {100, 100, 100},
                        {10000000},};
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(longestDistOfValidPair(arrays[i]));
        }

    }
}
