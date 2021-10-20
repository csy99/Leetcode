/**
 * Created by csy99 10/20/21.
 */
class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> repeat = new Stack();
        int count = 0;
        char prev = ' ';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (prev == cur) {
                count++;
                if (count == k) {
                    sb.setLength(sb.length()-k+1);
                    if (sb.length() > 0) {
                        prev = sb.charAt(sb.length()-1);
                        count = repeat.pop();
                    } else {
                        prev = ' ';
                        count = 0;
                    }
                } else {
                    sb.append(cur);
                }
            } else {
                repeat.push(count);
                count = 1;
                prev = cur;
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}
