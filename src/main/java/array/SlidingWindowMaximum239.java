package array;

/**
 * Created by user on 2019/1/7.
 */
public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        for (int num : maxSlidingWindow(nums, k)) System.out.print(num + ", ");
        System.out.println();
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n < 1 || n < k) return new int[0];
        int[] res = new int[n - k + 1];
        int slow = 0, fast = 0, max = nums[0], index = 0;
        for (; fast < k; fast++) {
            if (nums[fast] > max) {
                max = nums[fast];
                index = fast;
            }
        }
        res[0] = max;
        for (; fast < n; fast++) {
            if (nums[fast] > max) {
                max = nums[fast];
                index = fast;
            }
            slow = fast - k + 1;
            if (index < slow) {
                max = nums[slow];
                index = slow;
                for (; slow <= fast; slow++) {
                    if (nums[slow] > max) {
                        max = nums[slow];
                        index = slow;
                    }
                }
            }
            res[fast - k + 1] = max;
        }
        return res;
    }
}
