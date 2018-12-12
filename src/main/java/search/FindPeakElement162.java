package search;

/**
 * Created by 15501 on 2018/12/7.
 */
public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
        nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;
    }

//    public static int findPeakElement(int[] nums) {
//        int left = 0, right = nums.length - 1, mid;
//        while (left < right - 1) {
//            mid = left + (right - left) / 2;
//            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
//            if (nums[mid] > nums[mid - 1]) left = mid + 1;
//            else right = mid - 1;
//        }
//        return nums[left] > nums[right] ? left : right;
//    }
}
