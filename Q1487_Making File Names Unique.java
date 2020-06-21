/**
 * Created by csy99 on 6/21/20.
 */
class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        HashMap<String, Integer> map = new HashMap();
        String[] res = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(names[i])) {
                res[i] = names[i];
                map.put(names[i], 1);
            } else {
                int cnt = map.get(names[i]);
                sb.setLength(0);
                sb.append(names[i]).append("(").append(cnt).append(")");
                while (map.containsKey(sb.toString())) {
                    cnt++;
                    sb.setLength(0);
                    sb.append(names[i]).append("(").append(cnt).append(")");                    
                }
                res[i] = sb.toString();
                map.put(res[i], 1);
                map.put(names[i], cnt+1);
            }
        }
        return res;
    }
}
