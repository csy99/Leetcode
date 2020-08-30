package Leetcode;

/**
 * Created by csy99 on 8/30/20.
 */
public class Q406_Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] - arr2[0] != 0)
                    return arr1[0] - arr2[0];
                return arr1[1] - arr2[1];
            }
        });
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++)
            res[i][0] = -1;
        for (int i = 0; i < n; i++) {
            int height = people[i][0];
            int cnt = people[i][1];
            for (int j = 0; j < n; j++) {
                if (res[j][0] < 0 && cnt == 0) {
                    res[j] = people[i];
                    break;
                } else if (res[j][0] < 0 || res[j][0] >= height)
                    cnt--;
            }
        }
        return res;
    }
}
