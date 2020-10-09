/**
 * Created by csy99 on 10/9/20.
 */
public class Q540_Single_Element_in_a_Sorted_Array {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid == n-1) return mid;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid+1])
                    l = mid + 1;
                else
                    r = mid;
            } else {
                if (nums[mid-1] == nums[mid])
                    l = mid + 1;
                else
                    r = mid;
            }
        }
        return nums[l];
    }
}
