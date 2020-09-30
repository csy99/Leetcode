/**
 * Created by csy99 on 9/30/20.
 */
// T: length of target
// search, time: O(n^T * T^2), space: O(n*T)
class Solution {
    int best;
    int[][] stickersCnt;
    int[] tc;
    int n;
    
    public int minStickers(String[] stickers, String target) {
        int[] targetNaiveCnt = new int[26];
        for (char c: target.toCharArray())
            targetNaiveCnt[c - 'a']++;
        int[] index = new int[26];
        int t = 0;
        for (int i = 0; i < 26; i++) {
            if (targetNaiveCnt[i] > 0)
                index[i] = t++;
            else
                index[i] = -1;
        }
        tc = new int[t];
        t = 0;
        for (int c: targetNaiveCnt) {
            if (c > 0)
                tc[t++] = c;
        }
        n = stickers.length;
        stickersCnt = new int[n][t];
        for (int i = 0; i < n; i++) {
            for (char c: stickers[i].toCharArray()) {
                int j = index[c-'a'];
                if (j >= 0)
                    stickersCnt[i][j]++;
            }
        }
        int anchor = 0;
        for (int i = 0; i < n; i++) {
            for (int j = anchor; j < n; j++) {
                if (i == j) continue;
                boolean dominated = true;
                for (int k = 0; k < t; k++) {
                    if (stickersCnt[i][k] > stickersCnt[j][k]) {
                        dominated = false;
                        break;
                    }
                }
                if (dominated) {
                    int[] tmp = stickersCnt[i];
                    stickersCnt[i] = stickersCnt[anchor];
                    stickersCnt[anchor++] = tmp;
                    break;
                }
            }
        }
        best = target.length() + 1;
        search(0, anchor);
        if (best > target.length()) return -1;
        return best;
    }
    
    private void search(int cur, int row) {
        if (cur >= best)
            return;
        if (row == stickersCnt.length) {
            for (int c: tc)
                if (c > 0)
                    return;
            best = cur;
            return;
        }
        int used = 0;
        for (int i = 0; i < stickersCnt[row].length; i++) {
            if (tc[i] > 0 && stickersCnt[row][i] > 0) 
                used = Math.max(used, (tc[i]-1)/stickersCnt[row][i] + 1);
        }
        for (int i = 0; i < stickersCnt[row].length; i++)
            tc[i] -= used * stickersCnt[row][i];
        search(used + cur, row+1);
        while (used > 0) {
            for (int i = 0; i < stickersCnt[row].length; i++) 
                tc[i] += stickersCnt[row][i];
            used--;
            search(cur + used, row+1);
        }
    }
}

// S is the number of letters in one sticker
// dp, time: O(2^T * T * n * S), space: O(2^T)
class Solution {
    public int minStickers(String[] stickers, String target) {
        int T = target.length();
        int[] dp = new int[1 << T];
        for (int i = 1; i < 1<<T; i++)
            dp[i] = -1;
        for (int state = 0; state < 1<<T; state++) {
            if (dp[state] == -1) continue;
            for (String sticker: stickers) {
                int now = state;
                for (char c: sticker.toCharArray()) {
                    for (int i = 0; i < T; i++) {
                        if (((now >> i) & 1) == 1)
                            continue;
                        if (target.charAt(i) == c) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1)
                    dp[now] = dp[state] + 1;
            }
        }
        return dp[(1<<T)-1];
    }
}
