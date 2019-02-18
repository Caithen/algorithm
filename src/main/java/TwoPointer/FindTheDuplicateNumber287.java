package TwoPointer;

/**
 * Created by 15501 on 2019/2/8.
 */
public class FindTheDuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        nums = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate(nums));

    }

    // 二分搜索
    public static int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }
            if (cnt <= mid) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    // 快慢指针
//    public static int findDuplicate(int[] nums) {
//        if (nums.length < 1) return -1;
//        int slow = 0, fast = 0;
//        do {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        } while (slow != fast);
//        fast = 0;
//        while (slow != fast) {
//            slow = nums[slow];
//            fast = nums[fast];
//        }
//        return slow;
//    }
}
