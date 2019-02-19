package search.binarysearch;

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

        if (nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length - 1, mid;

        while (start + 1 < end) {

            mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {

                start = mid;

            } else {

                end--;

            }

        }

        return Math.min(nums[start], nums[end]);

    }

}
