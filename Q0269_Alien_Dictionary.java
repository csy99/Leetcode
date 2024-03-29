package Leetcode;

/**
 * Created by csy99 on 4/11/20.
 * 
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, 
 * where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 * 
 * You may assume all letters are in lowercase. The dictionary is invalid, if a is prefix of b and b is appear before a.
 * If the order is invalid, return an empty string.
 *
 * Input：["wrt","wrf","er","ett","rftt"]
 * Output："wertf"
 * Explanation：
 * from "wrt"and"wrf" ,we can get 't'<'f'
 * from "wrt"and"er" ,we can get 'w'<'e'
 * from "er"and"ett" ,we can get 'r'<'t'
 * from "ett"and"rftt" ,we can get 'e'<'r'
 * So return "wertf"
 */
public class Q269_Alien_Dictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap();
        int[] indegree = new int[26];
        buildGraph(graph, indegree, words);
        return bfs(graph, indegree);
    }
    
    private void buildGraph(Map<Character, Set<Character>> graph, int[] indegree, String[] words) {
        for (String word: words) {
            for (char c: word.toCharArray())
                graph.putIfAbsent(c, new HashSet<Character>());
        }
        /** cannot use the code below
         * every key in the map has to be a character in the words list
         * */
        // for (char c = 'a'; c <= 'z'; c++)
        //     graph.put(c, new HashSet<Character>());
        int n = words.length;
        for (int i = 1; i < n; i++) {
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for (int l = 0; l < len; l++) {
                // c1 is smaller than or equal to c2 in lexi order 
                char c1 = first.charAt(l);
                char c2 = second.charAt(l);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree[c2-'a']++;
                    }
                    break;
                }
                // impossible
                if (l+1 == len && first.length() > second.length()) {
                    graph.clear();
                    return;
                }
            }
        }
    }
    
    private String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList();
        for (char c: graph.keySet()) {
            // small in lexi order
            if (indegree[c-'a'] == 0)
                q.offer(c);
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char larger: graph.get(c)) {
                indegree[larger - 'a']--;
                if (indegree[larger-'a'] == 0)
                    q.offer(larger);
            }
        }
        if (sb.length() < graph.size())  // conflicts exist
            return "";
        return sb.toString();
    }
}

// 7/16/21
public class Solution {
    public String alienOrder(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> graph = new HashMap();
        for (String word: words) {
            for (char c: word.toCharArray())
                if (!graph.containsKey(c))
                    graph.put(c, new HashSet());
        }
        for (int i = 1; i < n; i++) {
            int m = words[i-1].length();
            char c1 = ' ';
            char c2 = ' ';
            for (int j = 0; j < m; j++) {
                if (j >= words[i].length()) // invalid dict
                    return "";
                c1 = words[i-1].charAt(j);
                c2 = words[i].charAt(j);
                if (c1 != c2) break;
            }
            if (c1 != c2)   // c1 < c2
                graph.get(c2).add(c1);
        }
        StringBuilder sb = new StringBuilder();
        List<Character> q = new ArrayList();
        for (char key: graph.keySet())
            if (graph.get(key).size() == 0)
                q.add(key);
        boolean[] seen = new boolean[26];
        while (q.size() > 0) {
            // return the smallest in normal lexicographical order
            Collections.sort(q);  
            char cur = q.remove(0);
            if (seen[cur-'a'])   
                continue;
            seen[cur-'a']  = true;    
            sb.append(cur);
            for (char key: graph.keySet()) {
                if (seen[key-'a']) continue;
                graph.get(key).remove(cur);
                if (graph.get(key).size() == 0)
                    q.add(key);
            }
        }
        if (sb.length() < graph.size()) return "";
        return sb.toString();
    }
}
