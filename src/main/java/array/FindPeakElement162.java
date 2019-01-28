package array;

/**
 * Created by 15501 on 2019/1/23.
 * 这里有一个注意事项：二分的边界条件时：left < right，因为要使用 mid + 1
 */
public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[mid + 1]) left = mid + 1;
            else right--;
        }
        return left;
    }
}
