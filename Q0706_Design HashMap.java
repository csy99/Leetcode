/**
 * Created by csy99 on 7/6/21.
 */
class MyHashMap {
    double load_factor = 0.75;
    Node[] arr = new Node[8];
    int cnt = 0;
    int op = 0;
    
    private int hashing(int key, int n) {
        return (((key >> 16) ^ 0xffff) + (key & 0xffff)) % n;
    }
    
    private void expand() {
        int n = arr.length;
        Node[] copy = new Node[n*2];
        for (int i = 0; i < n; i++) {
            if (arr[i] == null || !arr[i].valid) continue;
            Node cur = arr[i];
            int h = hashing(cur.key, n*2);
            insert(copy, h, cur);
        }
        arr = copy;
    }
    
    // insert new value, update old value if key exists
    private void insert(Node[] arr, int h, Node cur) {
        int n = arr.length;
        for (int i = h; i < n; i++) {
            if (arr[i] == null || (!arr[i].valid && arr[i].key == cur.key)) {
                arr[i] = cur;
                return;
            } else if (arr[i] != null && arr[i].key == cur.key) {
                arr[i].val = cur.val;
                return;
            }
        }
        for (int i = 0; i < h; i++) {
            if (arr[i] == null ||  (!arr[i].valid && arr[i].key == cur.key)) {
                arr[i] = cur;
                return;
            } else if (arr[i] != null && arr[i].key == cur.key) {
                arr[i].val = cur.val;
                return;
            }
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        cnt++;
        if ((double)cnt / arr.length >= load_factor)
            expand();
        int h = hashing(key, arr.length);
        Node cur = new Node(key, value);
        insert(arr, h, cur);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int n = arr.length;
        int h = hashing(key, n);
        for (int i = h; i < n; i++) {
            if (arr[i] == null) 
                return -1;
            else if (arr[i] != null && arr[i].key == key) {
                if (arr[i].valid)
                    return arr[i].val;
                else 
                    return -1;
            }
        }
        for (int i = 0; i < h; i++) {
            if (arr[i] == null) 
                return -1;
            else if (arr[i] != null && arr[i].key == key) {
                if (arr[i].valid)
                    return arr[i].val;
                else 
                    return -1;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int n = arr.length;
        int h = hashing(key, n);
        for (int i = h; i < n; i++) {
            if (arr[i] == null) 
                return;
            else if (arr[i] != null && arr[i].key == key) {
                arr[i].valid = false;
                return;
            }
        }
        for (int i = 0; i < h; i++) {
            if (arr[i] == null) 
                return;
            else if (arr[i] != null && arr[i].key == key) {
                arr[i].valid = false;
                return;
            }
        }
        cnt--;
    }
}

class Node {
    boolean valid;
    int key;
    int val;
    
    public Node(int k, int v) {
        valid = true;
        key = k;
        val = v;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
