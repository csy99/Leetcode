/**
 * Created by csy99 on 5/16/20. 
 */
class TimeMap {
    // HashMap + Binary Search
    HashMap<String, ArrayList<Pair<Integer, String>>> map;
    
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<Pair<Integer, String>>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        ArrayList<Pair<Integer, String>> arr = map.get(key);
        return binarySearch(arr, timestamp);
    }
    
    // timestamp is auto increasing
    private String binarySearch(ArrayList<Pair<Integer, String>> arr, int ts) {
        if (arr.size() == 0 || (arr.size() == 1 && arr.get(0).getKey() > ts))
            return "";
        else if (arr.size() == 1)
            return arr.get(0).getValue();
        int l = 0;
        int r = arr.size()-1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int stamp = arr.get(mid).getKey();
            if (stamp == ts)
                return arr.get(mid).getValue();
            else if (stamp < ts)
                l = mid + 1;
            else
                r = mid;
        }
        if (arr.get(l).getKey() <= ts)
            return arr.get(l).getValue();
        else if (l > 0 && arr.get(l-1).getKey() <= ts)
            return arr.get(l-1).getValue();
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
