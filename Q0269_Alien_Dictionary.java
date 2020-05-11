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
        graph.putIfAbsent(c, new HashSet<Character>() );
    }
    for (int i = 1; i < words.length; i++) {
      String first = words[i-1];
      String second = words[i];
      int len = Math.min(first.length(), second.length());
      for (int j = 0; j < len; j++) {
        // c1 is smaller than c2 in lexi order 
        char c1 = first.charAt(j);
        char c2 = second.charAt(j);
        if (c1 != c2) {
          if (!graph.get(c1).contains(c2)) {
            graph.get(c1).add(c2);
            indegree[c2 - 'a']++;
          }
          break;
        }
        
        if (j+1 == len && first.length() > second.length()) {
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
      if (indegree[c - 'a'] == 0)
        q.offer(c);
    }
    while (!q.isEmpty()) {
      char c = q.poll();
      sb.append(c);
      for (char larger: graph.get(c)) {
        indegree[larger - 'a']--;
        if (indegree[larger - 'a'] == 0)
          q.offer(larger);
      }
    }
    
    return sb.length() == graph.size()? sb.toString() : ""; 
  }
}
