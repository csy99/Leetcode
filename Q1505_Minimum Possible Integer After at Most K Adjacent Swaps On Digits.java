/**
 * Created by csy99 on 7/5/20.
 */
// basic idea: the MSB is most important, should be swapped first if possible (greedy)
// time: O(n^2), space: O(n)
class Solution {
    public String minInteger(String num, int k) {
        char[] arr = num.toCharArray();
        helper(arr, 0, k);
        return new String(arr);
    }
    
    private void helper(char[] arr, int idx, int k) {
        int n = arr.length;
        if (k == 0 || idx >= n)
            return;
        int min = arr[idx];
        int minIdx = idx;
        for (int i = idx+1; i < Math.min(idx+k+1, n); i++)
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        char tmp = arr[minIdx];
        for (int i = minIdx; i > idx; i--)
            arr[i] = arr[i-1];
        arr[idx] = tmp;
        helper(arr, idx+1, k-(minIdx-idx));
    }
}

// SementTree, time: O(n*log n), space: O(n)
class Solution {
    public String minInteger(String num, int k) {
        // stores the location of each digit
        List<Queue<Integer>> pqs = new ArrayList();
        for (int i = 0; i < 10; i++)
            pqs.add(new LinkedList<>());
        int n = num.length();
        for (int i = 0; i < n; i++)
            pqs.get(num.charAt(i) - '0').add(i);
        StringBuilder sb = new StringBuilder();
        SegmentTree seg = new SegmentTree(n);
        for (int i = 0; i < n; i++) {
            for (int digit = 0; digit <= 9; digit++) {
                if (pqs.get(digit).size() > 0) {
                    Integer pos = pqs.get(digit).peek();
                    // a few numbers already shifted to left
                    int shift = seg.getCountLessThan(pos);
                    if (pos - shift <= k) {
                        k -= pos - shift;
                        seg.add(pos);
                        pqs.get(digit).remove();
                        sb.append(digit);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

class SegmentTree {
    int[] nodes;
    int n;
    
    public SegmentTree(int a) {
        nodes = new int[4*a];
        n = a;
    }
    
    public void add(int num) {
        helper(num, 0, n, 0);
    }
    
    private void helper(int num, int l, int r, int node) {
        if (num < l || num > r) return;
        if (l == r) {
            nodes[node]++;
            return;
        }
        int mid = (l+r)/2;
        helper(num, l, mid, 2*node+1);
        helper(num, mid+1, r, 2*node+2);
        nodes[node] = nodes[2*node+1] + nodes[2*node+2];
    }
    
    public int getCountLessThan(int num) {
        return getter(0, num, 0, n, 0);
    }
    
    private int getter(int ql, int qr, int l, int r, int node) {
        if (qr < l || ql > r) return 0;
        if (ql <= l && qr >= r)
            return nodes[node];
        int mid = (l+r)/2;
        return getter(ql, qr, l, mid, 2*node+1) + getter(ql, qr, mid+1, r , 2*node+2);
    }
}
























// during contest, buggy version
    public String minInteger(String num, int k) {
        char[] arr = num.toCharArray();
        char[] copy = arr.clone();
        Arrays.sort(arr);
        // System.out.println("sorted version:" + Arrays.toString(arr));
        // System.out.println("original version:" + Arrays.toString(copy));
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == copy[i]) {
                System.out.println("I am here " + i);
                i++;
                continue;
            }
            int j = i+1;
            while (copy[j] != arr[i])
                j++;
            // just enough/not enough step to achieve optimal at arr[i]
            if (j-i >= k) {  
                char[] copy2 = copy.clone();
                swap(copy, i, i+k);
                swap(copy2, j-k, j);
                if (Long.parseLong(new String(copy2)) < Long.parseLong(new String(copy)))
                    copy = copy2;
                break;
            } else {
                swap(copy, i, j);
            }
            k -= j - i;
            // System.out.printf("i:%d, j:%d, k:%d\n", i, j, k);
            i++;
            // System.out.println(Arrays.toString(copy));
        }
        return new String(copy);
    }
    
    private void swap(char[] copy, int l, int r) {
        while (l < r) {
            char tmp = copy[r];
            copy[r] = copy[r-1];
            copy[r-1] = tmp;
            r--;
        }
    }
