/**
 * Created by csy99 on 5/3/20. 
 */
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        final int INF = (int)1e9;
        int m = arr1.length;
        // sort arr2 and delete all dup values
        Arrays.sort(arr2);
        int fast = 0;
        int n = 0;
        while (fast < arr2.length) {
            while (fast < arr2.length - 1 && arr2[fast] == arr2[fast+1])
                fast++;
            arr2[n++] = arr2[fast++];
        }
        // min steps to make a[0~i] valid by keeping a[i]
        int[] keep = new int[m];
        // no cost to keep the first element (always strictly increasing w/ only one element in arr)
        for (int i = 1; i < m; i++)
            keep[i] = INF;
        // swap[i][j]:= min steps to make a[0~i] valid by swapping a[i] with b[j]
        int[][] swap = new int[m][n];
        for (int j = 0; j < n; j++)
            swap[0][j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; j++)
                swap[i][j] = INF;
        
        for (int i = 1; i < m; i++) {
            int minKeep = INF;
            int minSwap = INF;
            for (int j = 0; j < n; j++) {
                if (j > 0)
                    minSwap = Math.min(minSwap, swap[i-1][j-1] + 1);
                if (arr1[i] > arr2[j])
                    minKeep = Math.min(minKeep, swap[i-1][j]);  
                if (arr1[i] > arr1[i-1])
                    keep[i] = keep[i-1];
                if (arr2[j] > arr1[i-1])
                    swap[i][j] = keep[i-1] + 1;
              
                swap[i][j] = Math.min(swap[i][j], minSwap);
                keep[i] = Math.min(keep[i], minKeep);
            }
        }
        int s = swap[m-1][0];
        for (int j = 1; j < n; j++)
            s = Math.min(s, swap[m-1][j]);
        int res = Math.min(s, keep[m-1]);
        return res >= INF ? -1 : res;
    }
}
