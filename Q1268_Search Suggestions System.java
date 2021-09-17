/**
 * Created by csy99 on 9/16/21.
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for (String prod: products) {
            Node cur = root;
            for (char c: prod.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) 
                    cur.children[idx] = new Node();
                cur = cur.children[idx];
            }
            cur.word = prod; 
        }
        List<List<String>> res = new ArrayList();
        char[] arr = searchWord.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            List<String> candidate = new ArrayList();
            Node cur = root;
            boolean valid = true;
            for (int j = 0; j <= i; j++) {
                if (cur.children[arr[j] - 'a'] == null) {
                    valid = false;
                    break;
                }
                cur = cur.children[arr[j] - 'a'];
            }
            if (valid) 
                search(candidate, cur);    
            res.add(candidate);
        }
        return res;
    }
    
    private void search(List<String> candidate, Node start) {
        if (candidate.size() >= 3) return;
        if (start.word != null) candidate.add(start.word);
        if (candidate.size() >= 3) return;
        for (int c = 0; c < 26; c++) {
            if (start.children[c] != null)
                search(candidate, start.children[c]);
        }
    }
}

class Node {
    String word;
    Node[] children;
    
    public Node() {
        word = null;
        children = new Node[26];
    }
}
