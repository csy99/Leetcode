/**
 * Created by csy99 on 9/16/21.
 */
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> res = new ArrayList();
        int n = username.length;
        Map<String, List<Status>> map = new HashMap();
        Map<String, Integer> freq = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            List<Status> ts2link = map.getOrDefault(username[i], new ArrayList());
            ts2link.add(new Status(timestamp[i], website[i]));
            map.put(username[i], ts2link);
        }
        for (String user: map.keySet()) {
            List<Status> ts2link = map.get(user);
            Collections.sort(ts2link, (a,b)->(Integer.compare(a.ts, b.ts)));
            Set<String> seen = new HashSet();
            int m = ts2link.size();
            for (int i = 0; i < m-2; i++) {
                String first = ts2link.get(i).website;
                for (int j = i+1; j < m-1; j++) {
                    String second = ts2link.get(j).website;
                    for (int k = j+1; k < m; k++) {
                        String third = ts2link.get(k).website;
                        sb.setLength(0);
                        sb.append(first).append(";").append(second).append(";").append(third);
                        String key = sb.toString();
                        if (seen.contains(key)) continue;
                        seen.add(key);
                        freq.put(key, freq.getOrDefault(key,0)+1);
                    }
                }
            }
        }
        String tmp = null;
        int freq_highest = 0;
        for (String key: freq.keySet()) {
            int f = freq.get(key);
            if (tmp == null || f > freq_highest || f == freq_highest && key.compareTo(tmp) < 0) {
                freq_highest = f;
                tmp = key;
            }
        }
        String[] arr = tmp.split(";");
        return Arrays.asList(arr);
    }
}

class Status {
    int ts;
    String website;
    
    public Status(int t, String link) {
        ts = t;
        website = link;
    }
}
