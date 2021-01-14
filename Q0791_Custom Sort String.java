/**
 * Created by csy99 on 1/13/21.
 */
class Solution {
    public String customSortString(String S, String T) {
        int m = S.length();
        int n = T.length();
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        Map<Character, Integer> map = new HashMap();
        for (char c: S.toCharArray()) 
            map.put(c, 0);
        for (char c: T.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                suffix.append(c);
        }
        for (char c: S.toCharArray()) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                prefix.append(c);
            }
        }
        prefix.append(suffix);
        return prefix.toString();
        
    }
}
