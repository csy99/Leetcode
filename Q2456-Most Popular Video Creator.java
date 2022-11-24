/**
 * Created by csy99 on 11/23/22.
 */
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> total_counts = new HashMap();
        Map<String, Integer> highest_views = new HashMap(); 
        Map<String, String> labels = new HashMap();
        int n = views.length;
        for (int i = 0; i < n; i++) {
            long prev_cnt = total_counts.getOrDefault(creators[i], 0L);
            long cur_cnt = prev_cnt + views[i];
            total_counts.put(creators[i], cur_cnt);
            
            int hi_view = highest_views.getOrDefault(creators[i], 0);
            if (hi_view == 0 || views[i] >= hi_view) {
                highest_views.put(creators[i], views[i]);
                String label = labels.getOrDefault(creators[i], null);
                if (label == null || (views[i] == hi_view && ids[i].compareTo(label) < 0) || views[i] > hi_view) {
                    labels.put(creators[i], ids[i]);
                }
            }
        }
        List<List<String>> res = new ArrayList();
        long largest_count = 0;
        for (long t_c: total_counts.values()) 
            largest_count = Math.max(largest_count, t_c);
        for (String name: total_counts.keySet()) {
            if (total_counts.get(name) != largest_count)
                continue;
            List<String> pair = new ArrayList();
            pair.add(name);
            pair.add(labels.get(name));
            res.add(pair);
        }
            
        return res;
    }
}
