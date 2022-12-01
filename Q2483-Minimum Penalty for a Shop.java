/**
 * Created by csy99 on 11/30/22.
 */
// counting
// time: O(n), space: O(1)
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int num_0 = 0;
        int num_1 = 0;
        char[] arr = customers.toCharArray();
        for (char c: arr) {
            if (c == 'Y')
                num_1++;
            else
                num_0++;
        }
        int res = num_1;
        int cost = num_1;
        int num_0_before = 0;
        int num_1_before = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'Y') 
                num_1_before++;
            else 
                num_0_before++;
            cost = num_0_before + num_1 - num_1_before;
            if (cost < res) {
                time = i+1;
                res = cost;
            }
        }
        return time;
    }
}
