package search;

/**
 * Created by 15501 on 2018/12/6.
 */
public class FindMinimumInRotatedSortedArrayII154 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(findMin(nums));
        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
        nums = new int[]{2,1};
        System.out.println(findMin(nums));
        nums = new int[]{1,3,5};
        System.out.println(findMin(nums));
        nums = new int[]{2,2,2,0,1};
        System.out.println(findMin(nums));
        nums = new int[]{10,1,10,10,10};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right--;
        }
        return nums[right];
    }

    // 先判断数组是否有序
//    public static int findMin(int[] nums) {
//        return findMinCore(nums, 0,  nums.length - 1);
//    }
//    private static int findMinCore(int[] nums, int left, int right) {
//        while (left < right) {
//            if (nums[left] < nums[right]) return nums[left];
//            if (nums[left] == nums[right]) {
//                int mid = left + (right - left) / 2;
//                int left_min = findMinCore(nums, left, mid);
//                int right_min = findMinCore(nums, mid + 1, right);
//                return Math.min(left_min, right_min);
//            } else {
//                int mid = left + (right - left) / 2;
//                if (nums[left] <= nums[mid]) left = mid + 1;
//                else right = mid;
//            }
//        }
//        return nums[right];
//    }
}
