package souhu;

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
    private static int findFirstElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        else return -1;
    }
    private static int findLastElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }
}
