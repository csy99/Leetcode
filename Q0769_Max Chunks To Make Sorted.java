/**
 * Created by csy99 on 10/27/21.
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        Stack<Integer> mono_st = new Stack();
        for (int i = 0; i < n; i++) {
            int largest = arr[i];
            while (mono_st.size() > 0 && mono_st.peek() > arr[i]) 
                largest = Math.max(largest, mono_st.pop());
            mono_st.push(largest);
        }
        return mono_st.size();
    }
}
