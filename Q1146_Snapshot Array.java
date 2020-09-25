/**
 * Created by csy99 on 9/25/20.
 */
class SnapshotArray {
    int id = 0;
    TreeMap<Integer, Integer>[] maps;
    
    public SnapshotArray(int length) {
        maps = new TreeMap[length];
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = maps[index];
        if (map == null)
            map = new TreeMap();
        map.put(id, val);
        maps[index] = map;
    }
    
    public int snap() {
        id += 1;
        return id - 1;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = maps[index];
        if (map == null)
            return 0;
        Integer lastChange = map.floorKey(snap_id);
        if (lastChange == null)
            return 0;
        return map.get(lastChange);
    }
}
