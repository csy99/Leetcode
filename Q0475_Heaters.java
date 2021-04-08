/**
 * Created by csy99 on 4/7/21.
 */
public class Q475_Heaters {
// time: O(n log n + m log n)
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(heaters);
        for (int house: houses)
            res = Math.max(res, find_smallest_diff(heaters, house));
        return res;
    }
    
    private int find_smallest_diff(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        while (l < r) {
            int m = (r-l)/2 + l;
            if (arr[m] == target) return 0;
            if (arr[m] < target)
                l = m+1;
            else
                r = m;
        }
        int res = Math.abs(arr[l] - target);
        if (l > 0)
            res = Math.min(res, Math.abs(arr[l-1] - target));
        return res;
    }
}
