package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by csy99 on 3/29/20.
 * <p>
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Different from the previous question where weight is increasing from root to leaf,
 * now the weight is defined from bottom up.
 * i.e., the leaf level integers have weight 1,
 * and the root level integers have the largest weight.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8.
 * (four 1's at depth 1, one 2 at depth 2)
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]], return 17.
 * (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */
public class Q364_Nested_List_Weight_Sum_II {
  // math
  public int depthSumInverse(List<NestedInteger> nestedList) {
    if (nestedList.size() == 0) return 0;
    int preSum = 0;
    int cur = 0;
    List<NestedInteger> list = nestedList;
    while (list.size() > 0) {
      List<NestedInteger> nextLevel = new ArrayList<NestedInteger>();
      for (NestedInteger ni: list) {
        if (ni.isInteger())
          cur += ni.getInteger();
        else
          nextLevel.addAll(ni.getList());
      }
      preSum += cur;
      list = nextLevel;
    }
    return preSum;
  }
}
