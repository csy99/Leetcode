package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 9/1/20.
 */
public class Q451_Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        int[] counts = new int[128];
        int n = s.length();
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        int highest = 0;
        for (char c: s.toCharArray()) {
            int key = (int) c;
            counts[key]++;
            if (counts[key] > highest)
                highest = counts[key];
            HashSet<Integer> set = map.getOrDefault(counts[key], new HashSet());
            set.add(key);
            map.put(counts[key], set);
            if (counts[key] == 1) continue;
            set = map.getOrDefault(counts[key]-1, new HashSet()); 
            set.remove(key);
            map.put(counts[key]-1, set);
        }
        StringBuilder sb = new StringBuilder();
        for (int freq = highest; freq > 0; freq--) {
            HashSet<Integer> set = map.get(freq);
            if (set == null || set.size() == 0) continue;
            for (int key: set) {
                char c = (char) key;
                for (int i = 0; i < freq; i++)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
