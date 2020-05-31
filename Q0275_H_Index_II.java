package Leetcode;

/**
 * Created by csy99 on 5/31/20.
 */
public class Q275_H_Index_II {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        int l = 0;
        int r = citations.length-1;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (citations[mid] < citations.length-mid)
                l = mid+1;
            else
                r = mid;
        }
        if (citations[l] < citations.length-l)
            return 0;
        return citations.length-l;
    }
}
