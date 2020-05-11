package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 *
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 *
 */
public class Q278_First_Bad_Version {
  public int firstBadVersion(int n) {
    int l = 1;
    int r = n;
    while (l < r) {
      int mid = l + (r-l)/2;
      if (isBadVersion(mid)) // the bad version might happen before this
        r = mid;
      else
        l = mid+1;
    }
    return r;
  }
    /**
     * Dummy API
     *
     * @param version
     * @return
     */
    public boolean isBadVersion(int version) {
        return false;
    }
}
