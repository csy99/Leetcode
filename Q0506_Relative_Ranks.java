package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 4/18/21.
 */
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        Item[] arr = new Item[n];
        for (int i = 0; i  < n; i++) {
            Item item = new Item(score[i],i);
            arr[i] = item;
        }
        Arrays.sort(arr, (a,b)->(b.point-a.point));
        for (int i = 0; i < n; i++) {
            int idx = arr[i].idx;
            if (i == 0)
                res[idx] = "Gold Medal";
            else if (i == 1)
                res[idx] = "Silver Medal";
            else if (i == 2)
                res[idx] = "Bronze Medal";
            else
                res[idx] = (i+1)+"";
        }
        return res;
    }
}

class Item {
    int point = 0;
    int idx = 0;
    
    public Item(int p, int i) {
        point = p;
        idx = i;
    }
    
}
