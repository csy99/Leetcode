/**
 * Created by csy99 on 10/4/21.
 */
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int m = indices.length;
        StringBuilder sb = new StringBuilder(s);
        Change[] changes = new Change[m];
        int offset = 0;
        for (int i = 0; i < m; i++) 
            changes[i] = new Change(indices[i], sources[i], targets[i]);
        Arrays.sort(changes);
        for (int i = 0; i < m; i++) {
            int start = changes[i].idx + offset;
            int ori_len = changes[i].source.length();
            if (!sb.substring(start, start+ori_len).equals(changes[i].source))
                continue;
            int new_len = changes[i].target.length();
            String right = sb.substring(start+ori_len);
            sb.setLength(start);
            sb.append(changes[i].target).append(right);
            offset += new_len - ori_len;
        }
        return sb.toString();
    }
}

class Change implements Comparable<Change>{
    int idx;
    String source;
    String target;
    
    public Change(int i, String s, String t) {
        idx = i;
        source = s;
        target = t;
    }
    
    public int compareTo(Change o) {
        return Integer.compare(idx, o.idx);
    }
}
