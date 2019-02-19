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

    public static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length - 1, mid;

        while (start + 1 < end) {

            mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] > nums[end] || nums[mid] > nums[start]) {

                if (nums[start] <= target && nums[mid] > target) {

                    end = mid;

                } else {

                    start = mid;

                }

            } else if (nums[mid] < nums[start] || nums[mid] < nums[end]) {

                if (nums[mid] < target && nums[end] >= target) {

                    start = mid;

                } else {

                    end = mid;

                }

            } else {

                end--;

            }

        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;

    }
}
