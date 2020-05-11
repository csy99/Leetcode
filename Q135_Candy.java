package Leetcode;

/**
 * Created by csy99 on 3/9/20.
 */
public class Q135_Candy {
    public int candy(int[] ratings) {
        public int candy(int[] ratings) {
      if (ratings == null)
        return 0;
      int[] candy = new int[ratings.length];
      candy[0] = 1;
      for (int i = 1; i < ratings.length; i ++) {
        if (ratings[i] > ratings[i - 1])
          candy[i] = candy[i - 1] + 1;
        else
          candy[i] = 1;
      }
      for (int i = ratings.length - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1])
          candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
      }
      int res = 0;
      for (int j = 0; j < candy.length; j++) {
        res += candy[j];
      }
      return res;
    }
}
