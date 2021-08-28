/**
 * Created by csy99 on 8/26/21.
 */
class Solution {
    // stack simulation, time: O(n), space: O(n)
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length()-1) == c) 
                sb.deleteCharAt(sb.length()-1);
            else 
                sb.append(c);
        }
        return sb.toString();
    }
}