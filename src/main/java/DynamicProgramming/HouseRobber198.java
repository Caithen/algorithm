package DynamicProgramming;

/**
 * Created by user on 2018/12/21.
 */
public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1}; // 4
        System.out.println(rob(nums));
        nums = new int[]{2,7,9,3,1}; // 12
        System.out.println(rob(nums));
        nums = new int[]{}; // 0
        System.out.println(rob(nums));
        nums = new int[]{2}; // 2
        System.out.println(rob(nums));
        nums = new int[]{2,1,1,2}; // 4
        System.out.println(rob(nums));
        nums = new int[]{3, 1, 1, 4, 1, 1, 5}; // 12
        System.out.println(rob(nums));
    }

    // 空间优化的动态规划，
    // 维持两个变量：rob表示抢这间，notRob表示不抢这间
    public static int rob(int[] nums) {
        int pre = 0, cur = 0, res = 0;
        for (int num : nums) {
            res = Math.max(pre + num, cur);
            pre = cur;
            cur = res;
        }
        return res;
    }

    // 下面是最简单粗暴的动态规划
//    public static int rob(int[] nums) {
//        if (nums.length < 1) return 0;
//        if (nums.length < 2) return nums[0];
//        int[] dp = new int[nums.length + 1];
//        dp[1] = nums[0]; dp[2] = nums[1];
//        for (int i = 3; i <= nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
//        }
//        int res = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }
}
