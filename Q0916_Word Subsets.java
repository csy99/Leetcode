/**
 * Created by csy99 on 4/4/21.
 */
 class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList();
        int[] requirements = new int[26];
        for (String dict: B) {
            int[] copy = new int[26];
            for (char c: dict.toCharArray())
                copy[c-'a']++;
            for (int i = 0; i < 26; i++)
                requirements[i] = Math.max(requirements[i],copy[i]);
        }
        for (String str: A) {
            int[] chars = new int[26];
            for (char c: str.toCharArray())
                chars[c-'a']++;
            boolean is_universal = true;
            for (int i = 0; i < 26; i++)
                if (chars[i] < requirements[i]) {
                    is_universal = false;
                    break;
                }
            if (is_universal)
                res.add(str);
        }
        return res;
    }
}
