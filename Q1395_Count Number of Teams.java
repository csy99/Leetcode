/**
 * Created by csy99 on 7/31/21.
 */
// counting, time: O(n^2), space: O(1)
class Solution {
    public int numTeams(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            int leftSmaller = 0;
            int leftLarger = 0;
            int rightSmaller = 0;
            int rightLarger = 0;
            for (int i = 0; i < j; i++) {
                if (arr[i] < arr[j])
                    leftSmaller++;
                else if (arr[i] > arr[j])
                    leftLarger++;
            }
            for (int k = j+1; k < n; k++) {
                if (arr[k] < arr[j])
                    rightSmaller++;
                else if (arr[k] > arr[j])
                    rightLarger++;
            }
            res += leftSmaller*rightLarger + rightSmaller*leftLarger;
        }
        return res;
    }
}
