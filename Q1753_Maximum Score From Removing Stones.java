/**
 * Created by csy99 on 2/6/2021 during contest. 
 */
class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        int small = arr[0]+arr[1];
        return Math.min(sum / 2, small);
    }
}
