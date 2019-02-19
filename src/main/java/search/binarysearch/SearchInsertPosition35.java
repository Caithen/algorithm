package search.binarysearch;

/**
 * Created by 15501 on 2019/2/18.
 */
public class SearchInsertPosition35 {
    public static void main(String[] args) {

    }
    private static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) return start;
        if (nums[end] >= target) return end;
        return end + 1;
    }
}
