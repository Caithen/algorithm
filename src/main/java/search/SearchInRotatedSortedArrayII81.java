package search;

/**
 * Created by 15501 on 2018/11/10.
 */
public class SearchInRotatedSortedArrayII81 {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
//        int target = 3;
//        int[] nums = {2, 3, 3, 5, 6, 7, 0, 1, 2};
//        int target = 7;
        int[] nums = {6, 7, 0, 1, 2, 3, 4, 5};
        int target = 0;
//        int[] nums = {1,1,3,1};
//        int target = 3;
        System.out.println(search(nums, target));
    }
    public static boolean search(int[] nums, int target) {
        if (nums.length < 1) return false;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] > nums[mid] || nums[right] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else if (nums[left] < nums[mid] || nums[right] < nums[mid]) {
                if (nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            } else {
                right--;
            }
        }
        return false;
    }
}
