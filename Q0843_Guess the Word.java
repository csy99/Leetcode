/**
 * Created by csy99 on 5/20/21.
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int N = 6;
        for (int t = 0, x = 0; t < 10 && x < 6; t++) {
            int cnt[][] = new int[N][26];
            int best = 0;
            for (String word: wordlist) {
                for (int i = 0; i < N; i++)
                    cnt[i][word.charAt(i)-'a']++;
            }
            String guess = wordlist[0];
            for (String word: wordlist) {
                int score = 0;
                for (int i = 0; i < N; i++)
                    score += cnt[i][word.charAt(i)-'a'];
                if (score > best) {
                    guess = word;
                    best = score;
                }
            }
            x = master.guess(guess);
            List<String> list = new ArrayList();
            for (String word: wordlist) {
                if (match(guess, word) == x)
                    list.add(word);
            }
            wordlist = list.toArray(new String[0]);
        }
    }
    
    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i))
                matches ++;
        return matches;
    }
}
