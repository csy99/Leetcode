/**
 * Created by csy99 on 5/19/20.
 */
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0)
            return new int[][] {};
        ArrayList<int[]> intersections = new ArrayList();
        int i = 0; 
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if (a[1] < b[0])
                i++;
            else if (a[0] > b[1])
                j++;
            else {
                int start = Math.max(a[0], b[0]);
                int end = Math.min(a[1], b[1]);
                int[] inter = new int[] {start, end};
                intersections.add(inter);
                if (a[1] < b[1])
                    i++;
                else
                    j++;
            }
        }
        int[][] res = new int[intersections.size()][2];
        for (int k = 0; k < res.length; k++) 
            res[k] = intersections.get(k);
        return res;
    }
}
 
