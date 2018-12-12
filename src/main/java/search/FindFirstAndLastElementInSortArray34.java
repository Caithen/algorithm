package search;

/**
 * Created by 15501 on 2018/11/11.
 */
public class FindFirstAndLastElementInSortArray34 {
    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
//        int[] nums = {5,7,7,8,8,10};
//        int target = 6;
        int[] nums = {1};
        int target = 0;
        for (int i : searchRange(nums, target))
            System.out.print(i + "    ");
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirstElement(nums, target);
        res[1] = findLastElement(nums, target);
        return res;
    }
    public static int findFirstElement(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (left < nums.length && nums[left] == target) return left;
        else return -1;
    }
    public static int findLastElement(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        if (right >= 0 && nums[right] == target) return right;
        else return -1;
    }
}
