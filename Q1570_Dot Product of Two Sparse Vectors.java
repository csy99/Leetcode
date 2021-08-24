/**
 * Created by csy99 on 8/23/21.
 */
// fastest would certainly be to store them using hashmap if we dont care ordering.
// if we do care ordering, use arraylist or array to store pairs of dimension and value, then do two pointers.
// For follow-up. we can use an extra hashmap to store dimension as key, its index in list as value. But the interviewers just want to ask you for binary search.
// Sure there must be reasons for ML group if they actually store vectors this way, But for non-ML people, why would I use O(logN) if I can do O(1)?
class SparseVector {
    List<int[]> rep;
    
    SparseVector(int[] nums) {
        rep = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int[] pair = new int[2];
            pair[0] = i;
            pair[1] = nums[i];
            rep.add(pair);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int m = this.rep.size();
        int n = vec.rep.size();
        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < m && j < n) {
            if (i < m && j < n && this.rep.get(i)[0] < vec.rep.get(j)[0]) {
                i++;
                continue;
            }
            if (i < m && j < n && this.rep.get(i)[0] > vec.rep.get(j)[0]) {
                j++;
                continue;
            }
            if (i >= m || j >= n) break;
            sum += rep.get(i)[1] * vec.rep.get(j)[1];
            i++;
            j++;
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
