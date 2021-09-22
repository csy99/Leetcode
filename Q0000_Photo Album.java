/**
 * Created by csy99 on 9/22/21.
 */
class Solution {

    public static List<Integer> photoAlbumOrder(int[] indices, int[] photos) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<Integer> st1 = new Stack();
        Stack<Integer> st2 = new Stack();
        int n = indices.length;
        for (int i = 0; i < n; i++) {
            if (indices[i] > st1.size()) {
                while (indices[i] > st1.size())
                    st1.push(st2.pop());
            } else if (indices[i] < st1.size()) {
                while (indices[i] < st1.size())
                    st2.push(st1.pop());
            }
            st1.push(photos[i]);
        }
        while (st1.size() > 0) {
            int num = st1.pop();
            res.add(0, num);
        }
        while (st2.size() > 0) {
            int num = st2.pop();
            res.add(num);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] indices = new int[] {0, 1, 2, 1, 2};
        int[] photos = new int[] {0, 1, 2, 3, 4};
        List<Integer> res = photoAlbumOrder(indices, photos);
        System.out.println(res);
    }
}
