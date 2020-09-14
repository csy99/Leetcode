/**
 * Created by csy99 on 9/13/20.
 */
class Solution {
    public boolean isTransformable(String s, String t) {
        int n = s.length();
        List<Integer>[] indices = (ArrayList<Integer>[]) new ArrayList[10];
        for (int i = 0; i < 10; i++)
            indices[i] = new ArrayList();
        for (int i = 0; i < n; i++)
            indices[s.charAt(i) - '0'].add(i);
        for (char c: t.toCharArray()) {
            int digit = c - '0';
            if (indices[digit].size() == 0)  // 两个字符串中字符不匹配
                return false;
            // 利用贪心思路拿到t中第一个相同数字试图往前交换
            int position = indices[digit].get(0);
            for (int d = 0; d < digit; d++) {
                if (indices[d].size() > 0 && indices[d].get(0) < position)
                    return false;
            }
            indices[digit].remove(0);
        }
        return true;
    }
}
