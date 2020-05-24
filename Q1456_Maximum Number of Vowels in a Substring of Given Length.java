/**
 * Created by csy99 on 5/23/20 during contest. 
 */
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        boolean[] isVow = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a' ||
               s.charAt(i) == 'e' ||
               s.charAt(i) == 'i' ||
               s.charAt(i) == 'o' ||
               s.charAt(i) == 'u')
                isVow[i] = true;
            if (i < k && isVow[i]) 
                res++;
        }
        if (n < k)
            return res;
        int[] cnt = new int[n-k+1];
        cnt[0] = res;
        for (int i = 1; i < n-k+1; i++) {
            cnt[i] = cnt[i-1];
            if (isVow[i-1])
                cnt[i]--;
            if (isVow[i+k-1])
                cnt[i]++;
            if (cnt[i] > res)
                res = cnt[i];
        }
        return res;
    }
}
