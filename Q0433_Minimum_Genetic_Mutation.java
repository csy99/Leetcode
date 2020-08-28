package Leetcode;

public class Q433_Minimum_Genetic_Mutation {
    int shortest = 10;
    char[] vocab = new char[]{'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> dict = new HashSet();
        for (String s: bank)
            dict.add(s);
        if (!dict.contains(end))
            return -1;
        dict.remove(start);
        helper(start, end, dict, 0);
        if (shortest >= 10) return -1;
        return shortest;
    }
    
    private void helper(String cur, String end, HashSet<String> dict, int step) {
        if (cur.equals(end)) {
            shortest = Math.min(shortest, step);
            return;
        }
        int n = end.length();
        for (int i = 0; i < n; i++) {
            char c = cur.charAt(i);
            for (char nt: vocab) {
                if (c == nt) continue;
                String candidate = cur.substring(0, i) + nt + cur.substring(i+1);
                if (dict.contains(candidate)) {
                    dict.remove(candidate);
                    helper(candidate, end, dict, step+1);
                    dict.add(candidate);
                }
            }
        }
    }
}
