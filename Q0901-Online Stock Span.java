/**
 * Created by csy99 on 11/8/22.
 */
// Mono Stack.
// time: O(n), space: O(n)
class StockSpanner {
    Stack<Integer> mono_st;
    Stack<Integer> cnt_st;
    
    public StockSpanner() {
        mono_st = new Stack();
        cnt_st = new Stack();
    }
    
    public int next(int price) {
        if (mono_st.isEmpty() || price < mono_st.peek()) {
            mono_st.add(price);
            cnt_st.add(1);
            return 1;
        }
        int cur = 1;
        while (mono_st.size() > 0 && price >= mono_st.peek()) {
            mono_st.pop();
            cur += cnt_st.pop();
        }
        mono_st.add(price);
        cnt_st.add(cur);
        return cur;
    }
}
