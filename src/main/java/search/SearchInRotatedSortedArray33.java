package search;

/**
 * Created by 15501 on 2018/11/10.
 */
public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
        int target = 3;
        int[] nums = {2, 3, 3, 5, 6, 7, 0, 1, 2};
//        int target = 7;
//        int[] nums = {6, 7, 0, 1, 2, 3, 4, 5};
//        int target = 0;
//        int[] nums = {1,1,3,1};
//        int target = 3;
        System.out.println(search(nums, target));
    }

    // 这个方法不能通过一些含有重复元素的旋转数组。
//    public static int search(int[] nums, int target) {
//        if (nums.length < 1) return -1;
//        int left = 0, right = nums.length - 1, mid;
//        while (left <= right) {
//            mid = (left + right) / 2;
//            if (nums[mid] == target) return mid;
//            if (nums[mid] > target) {
//                // left - mid 为顺序，然而 nums[left] 仍然 > target，就只能left右移了
//                if (nums[left] <= nums[mid] && nums[left] > target) left = mid + 1;
//                else right = mid - 1;
//            } else {
//                // mid - right 为顺序，然而 nums[right] 仍然 < target，就只能right左移了
//                if (nums[mid] <= nums[right] && nums[right] < target) right = mid - 1;
//                else left = mid + 1;
//            }
//        }
//        return -1;
//    }

    // 这个方法允许旋转数组中存在重复元素
    public static int search(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
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
        return -1;
    }
}
