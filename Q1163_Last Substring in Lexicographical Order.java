/**
 * Created by csy99 on 8/28/21.
 */
class Solution {
    // two pointer, time: O(n), space: O(1)
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 1;
        int offset = 0;
        while (i + offset < n && j + offset < n) {
            char c1 = s.charAt(i+offset);
            char c2 = s.charAt(j+offset);
            if (c1 == c2)  // compare next non-equal char
                offset++;
            else {
                if (c1 < c2)
                    i += offset+1;
                else
                    j += offset+1;
                if (i == j)  // avoid duplicate start indices
                    j++;
                offset = 0;
            }
        }
        return s.substring(i);
    }
}
