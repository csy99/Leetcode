/**
 * Created by csy99 on 11/6/21.
 */
class OrderedStream {
    String[] arr;
    int lastLargest = 0;
    public OrderedStream(int n) {
        arr = new String[n+1];
    }
    
    public List<String> insert(int id, String value) {
        arr[id] = value;
        List<String> res = new ArrayList();
        if (id == lastLargest + 1) {
            while (id < arr.length && arr[id] != null) {
                res.add(arr[id]);
                id++;
            }
            lastLargest = id-1;
        }
        return res;
    }
}
