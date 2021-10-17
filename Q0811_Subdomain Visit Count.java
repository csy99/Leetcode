/**
 * Created by csy99 on 10/17/21.
 */
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String domain: cpdomains) {
            String[] arr = domain.split(" ");
            int cnt = Integer.parseInt(arr[0]);
            String[] subdomains = arr[1].split("\\.");
            int n = subdomains.length;
            sb.setLength(0);
            for (int i = n-1; i >= 0; i--) {
                if (i < n-1)
                    sb.insert(0, ".");
                sb.insert(0, subdomains[i]);
                String cur = sb.toString();
                counts.put(cur, counts.getOrDefault(cur, 0) + cnt);
            }
        }
        for (String subdomain: counts.keySet()) {
            sb.setLength(0);
            int cnt = counts.get(subdomain);
            sb.append(cnt).append(" ").append(subdomain);
            res.add(sb.toString());
        }
        return res;
    }
}
