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
    HashMap<String, String> map = new HashMap();
    /*
    * @param dictionary: a list of words
    */
    public ValidWordAbbr(String[] dictionary) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dictionary.length; i++) {
            sb.setLength(0);
            if (dictionary[i].length() > 0)
                sb.append(dictionary[i].charAt(0));
            if (dictionary[i].length() > 2)
                sb.append(dictionary[i].length() - 2);
            if (dictionary[i].length() > 1)
                sb.append(dictionary[i].charAt(dictionary[i].length() - 1));
            String key = sb.toString();    
            if (!map.containsKey(key) || map.get(key).equals(dictionary[i])) 
                map.put(key, dictionary[i]);
            else
                map.put(key, "-1");
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        StringBuilder sb = new StringBuilder();
        if (word.length() > 0)
            sb.append(word.charAt(0));
        if (word.length() > 2)
            sb.append(word.length() - 2);
        if (word.length() > 1)
            sb.append(word.charAt(word.length() - 1));
        String key = sb.toString(); 
        return !map.containsKey(key) || map.get(key).equals(word);
    }
}
