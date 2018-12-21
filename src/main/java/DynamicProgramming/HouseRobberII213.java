package DynamicProgramming;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by user on 2018/12/21.
 */
public class HouseRobberII213 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
        nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
        nums = new int[]{2};
        System.out.println(rob(nums));
    }

    // 下面的方法比较蠢,但网上好像就这个一种解法，
    // 分别算了一遍抢nums[0]和不抢nums[0]的结果，取大者
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0), rob(nums, 1));
    }
    public static int rob(int[] nums, int start) {
        int rob = 0, notRob = 0, preRob, preNotRob;
        for (int i = start; i < nums.length - 1 + start; i++) {
            preRob = rob; preNotRob = notRob;
            rob = preNotRob + nums[i];
            notRob = Math.max(preNotRob, preRob);
        }
        return Math.max(rob, notRob);
    }
}
