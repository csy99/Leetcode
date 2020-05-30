package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 5/30/20.
 */
public class Q299_Bulls_and_Cows {
    public String getHint(String secret, String guess) {
        int[] cnt = new int[10];
        int bull = 0;
        int cow = 0;
        for (char c: secret.toCharArray()) 
            cnt[c-'0']++;
        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            if (g == secret.charAt(i)) {
                bull++;
                if (cnt[g-'0'] <= 0)  // mistreated as cow in previous positions
                    cow--;
            } else if (cnt[g-'0'] > 0) 
                cow++;
            cnt[g-'0']--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull).append("A").append(cow).append("B");
        return sb.toString();
    }
}
