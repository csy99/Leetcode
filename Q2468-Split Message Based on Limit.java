/**
 * Created by csy99 on 11/17/22.
 */
// Math
// time: O(n), space: O(n)
class Solution {
    public String[] splitMessage(String message, int limit) {
        int n = message.length();
        int suffix_len = 5;
        // impossible to split because limit too short
        if (limit <= suffix_len) return new String[0];
        int digits = 4;
        if (n + 9*5 <= 9 * limit)
            digits = 1;
        else if (n + 9*6 + 90*7 <= 99 * limit)
            digits = 2;
        else if (n + 9*6 + 90*7 + 900*8 <= 999 * limit)
            digits = 3;
        suffix_len += digits - 1;
        
        int pos = 0;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        List<String> parts = new ArrayList();
        while (pos < n) {
            int text_len = limit - suffix_len;
            if (text_len <= 0) return new String[0];
            int end = Math.min(pos+text_len, n);
            sb.append(message.substring(pos, end)).append("<").append(count).append("/");
            parts.add(sb.toString());
            sb.setLength(0);
            pos += text_len;
            count++;
            if (count == 10)
                suffix_len++;
            if (count == 100)
                suffix_len++;
            if (count == 1000)
                suffix_len++;
        }
        count--;
        
        String[] res = new String[parts.size()];
        for (int i = 0; i < res.length; i++) {
            sb.append(parts.get(i)).append(count).append(">");
            res[i] = sb.toString();
            sb.setLength(0);
        }
        return res;
    }
}
