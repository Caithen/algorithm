package array;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by user on 2019/1/4.
 */
public class MaxSubArray53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        nums = new int[]{-10};
        System.out.println(maxSubArray(nums));
    }

    // 题目要求用分而治之的方法，但这种方法的时间复杂度是O(nlogn)
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    private static int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; i--) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; i++) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }


    // 下面是O(n)的方法
//    public static int maxSubArray(int[] nums) {
//        int res = Integer.MIN_VALUE, sum = 0;
//        for (int num : nums) {
//            sum = Math.max(num, sum + num);
//            res = Math.max(res, sum);
//        }
//        return res;
//    }
}
