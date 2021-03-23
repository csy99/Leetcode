/**
 * Created by csy99 on 3/23/2021.
 */
// refs:
// - https://leetcode.com/problems/self-crossing/discuss/900931/This-explaination-made-my-life-easy
class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n < 4) return false;
        for (int i = 3; i < n; i++) {
            if (distance[i-3] >= distance[i-1] && distance[i] >= distance[i-2])
                return true;
            if (i >= 4 && distance[i-3] == distance[i-1] && (distance[i] + distance[i-4]) >= distance[i-2]) 
                return true;
            if (i >= 5 && distance[i-2] >= distance[i-4] && distance[3] >= distance[i-1] && 
               (distance[i-5]+distance[i-1]) >= distance[i-3] && (distance[i] + distance[i-4]) >= distance[i-2])
                return true;
        }
        return false;
    }
}
