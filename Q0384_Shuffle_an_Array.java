package Leetcode;

import java.util.Random;

/**
 * Created by csy99 on 4/12/20.
 * <p>
 * Shuffle a set of numbers without duplicates.
 */
public class Q384_Shuffle_an_Array {
    private int[] array;
    private int[] ori;
    Random rand = new Random();
    
    private int randRange(int min, int max) {
        return rand.nextInt(max-min)+min;
    }
    
    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
        
    public Solution(int[] nums) {
        array = nums;
        ori = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = ori;
        ori = ori.clone();
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++)
            swap(i, randRange(i, array.length));
        return array;
    }
}
