/**
 * Created by csy99 on 10/17/20.
 *
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list. Your job is to implement the following functions:
The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 */
public class AutocompleteSystem {
    TrieNode root;
    TrieNode copy;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        copy = root;
        sb = new StringBuilder();
        int n = times.length;
        for (int i = 0; i < n; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    private void add(String sent, int t) {
        TrieNode cur = root;
        List<TrieNode> path = new ArrayList();
        for (char c: sent.toCharArray()) {
            if (cur.children[c] == null)
                cur.children[c] = new TrieNode();
            cur = cur.children[c];
            path.add(cur);
        }
        cur.s = sent;
        cur.times = t;  // +=
        for (TrieNode node: path) 
            node.update(cur);
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList();
        if (c == '#') {
            add(sb.toString(), 1);
            sb.setLength(0);
            copy = root;
            return res;
        }
        if (copy == null)
            return res;
        copy = copy.children[c];
        for (TrieNode node: copy.hot) 
            res.add(node.s);
        return res;
    }
}

/**
 * Only at the last char of each sentence will the field s and times be filled. 
 */
class TrieNode implements Comparable<TrieNode> {
    TrieNode[] children;
    String s;
    int times;
    List<TrieNode> hot;
    
    public TrieNode() {
        children = new TrieNode[128];
        s = null;
        times = 0;
        hot = new ArrayList();
    }
    
    @Override
    public int compareTo(TrieNode o) {
        if (this.times == o.times)
            return s.compareTo(o.s);
        return o.times - this.times;
    }
    
    public void update(TrieNode cur) {
        if (!hot.contains(cur)) 
            hot.add(cur);
        Collections.sort(hot);
        if (hot.size() > 3)
            hot.remove(hot.size()-1);
    }
}

