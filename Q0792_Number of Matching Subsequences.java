/**
 * Created by csy99 on 6/22/21.
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<Item>[] dict = new Queue[26];
        for (int i = 0; i < 26; i++)
            dict[i] = new LinkedList();
        int res = 0;
        for (String word: words) {
            if (word.length() > 0)
                dict[word.charAt(0) - 'a'].add(new Item(word, 0));
        }
        for (char c: s.toCharArray()) {
            Queue<Item> q = dict[c-'a'];
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Item top = q.remove();
                top.idx++;
                if (top.idx == top.word.length())
                    res++;
                else
                    dict[top.word.charAt(top.idx)-'a'].add(top);
            }
        }
        return res;
    }
}

class Item {
    String word;
    int idx;
    public Item(String s, int i) {
        word = s;
        idx = i;
    }
}
