package Leetcode;

/**
 * Created by csy99 on 4/21/20.
 */
public class Q472_Concatenated_Words {
    
    Map<String, Boolean> cache = new HashMap();
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList();
        Set<String> dict = new HashSet();
        for (String word: words)
            dict.add(word);
        for (String word: words)
            if (dfs(word, dict))
                res.add(word);
        return res;
    }
    
    private boolean dfs(String word, Set<String> dict) {
        if (cache.containsKey(word))
            return cache.get(word);
        int n = word.length();
        for (int i = 1; i < n; i++) {
            if (!dict.contains(word.substring(0,i)))
                continue;
            String sub = word.substring(i);
            if (dict.contains(sub) || dfs(sub, dict)) {
                cache.put(word, true);
                return true;
            }
        }
        cache.put(word, false);
        return false;
    }
}
