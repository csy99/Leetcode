package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by csy99 on 4/1/20.
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 */
public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {
  // binary search
  // It takes log(m * n) times to find mid, and using (m + n) times to get count in each loop, so time complexity is O((m + n) log (m * n)).
  // O( (m+n) * log(max - min) ) to be exact
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    if (n == 0) return 0;
    int lo = matrix[0][0];
    int hi = matrix[n-1][n-1];
    while (lo < hi) {
      int mid = lo + (hi-lo)/2;
      int cnt = 0;
      int j = n-1;
      // count how many numbers <= mid and compare with k
      for (int i = 0; i < n; i++) {
        while (j >= 0 && matrix[i][j] > mid)
          j--;
        cnt += j+1;
      }
      if (cnt < k)
        lo = mid+1;
      else
        hi = mid;
    }
    return lo;
  }
    
  // Heap
  // time: O(n^2*log k)
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        pq.offer(matrix[i][j]);
        if (pq.size() > k)
          pq.poll();
      }
    }
    return pq.poll();
  }  
}
