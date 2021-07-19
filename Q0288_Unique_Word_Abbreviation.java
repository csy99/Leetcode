package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by csy99 on 4/19/20.
 * <p>
 * An abbreviation of a word follows the form
 * <first letter><number><last letter>.
 * Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 * <p>
 * 1
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * <p>
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * <p>
 * Understand the problem:
 * The question is a little bit tricky.
 * There are only 2 conditions we return true for isUnique("word")
 * 1. The abbr does not appear in the dict.
 * 2. The abbr is in the dict && the word appears one and only once in the dict.
 */
public class Q288_Unique_Word_Abbreviation {
    /*
    * @param dictionary: a list of words
    */
    Map<String, String> abbrs = new HashMap();
    StringBuilder sb = new StringBuilder();
    public ValidWordAbbr(String[] words) {
        for (String word: words) {
            String abbr = getAbbr(word);
            if (!abbrs.containsKey(abbr))
                abbrs.put(abbr, word);
            else if (!abbrs.get(abbr).equals(word))
                abbrs.put(abbr, "-");
        }
    }

    private String getAbbr(String word) {
        if (word.length() < 3) 
            return word;
        sb.setLength(0);
        sb.append(word.charAt(0));
        sb.append(word.length()-2);
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!abbrs.containsKey(abbr)) return true;
        if (abbrs.get(abbr).equals(word)) return true;
        return false;
    }
}
