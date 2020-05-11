package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by csy99 on 3/29/20.
 * <p>
 * <p>
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
public class Q339_Nested_List_Weight_Sum {
  public int depthSum(List<NestedInteger> nestedList) {
    if (nestedList.size() == 0) return 0;
    return dfs(nestedList, 1);
  }
  
  private int dfs(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger ni: nestedList) {
      if (ni.isInteger()) 
        sum += ni.getInteger() * depth;
      else
        sum += dfs(ni.getList(), depth+1);
    }
    return sum;
  }
}
