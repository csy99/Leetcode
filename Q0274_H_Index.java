package Leetcode;

/**
 * Created by csy99 on 5/31/20.
 */
public class Q274_H_Index {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return citations.length;
        Arrays.sort(citations);
        int i = 0;
        for (i = citations.length-1; i >= 0; i--) {
            if (citations[i] < citations.length-i)
                break;
        }
        return citations.length-i-1;
    }
}
