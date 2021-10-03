/**
 * Created by csy99 on 10/3/21.
 */
class RLEIterator {
    int[] arr;
    int len;
    int i;
    
    public RLEIterator(int[] encoding) {
        arr = encoding;    
        len = arr.length;
        i = 0;
    }
    
    public int next(int n) {
        if (i >= len) return -1;
        if (arr[i] >= n) {
            arr[i] -= n;
            return arr[i+1];
        } else {
            n -= arr[i];
            i += 2;
            return next(n); 
        }
    }
}
