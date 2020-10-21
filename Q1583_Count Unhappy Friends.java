/**
 * Created by csy99 on 9/12/20 during contest.
 */
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int[] pair: pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        for (int person: map.keySet()) {
            int first = person;
            int second = map.get(first);
            boolean flag = false;
            for (int i = 0; i < n-1; i++) {
                if (preferences[first][i] == second)
                    break;
                int potential = preferences[first][i];
                int pot_other = map.get(potential);
                for (int j = 0; j < n-1; j++) {
                    if (preferences[potential][j] == pot_other)
                        break;
                    if (preferences[potential][j] == first) {
                        res++;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
        }
        return res;
    }
}
