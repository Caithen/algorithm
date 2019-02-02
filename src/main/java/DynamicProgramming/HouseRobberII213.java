package DynamicProgramming;

/**
 * Created by user on 2018/12/21.
 */
public class HouseRobberII213 {
    public static void main(String[] args) {
        int[] nums = {2,3,2}; // 3
        System.out.println(rob(nums));
        nums = new int[]{1,2,3,1}; // 4
        System.out.println(rob(nums));
        nums = new int[]{2}; // 2
        System.out.println(rob(nums));
    }

    // 下面的方法比较蠢,但网上好像就这个一种解法，
    // 分别算了一遍抢nums[0]和不抢nums[0]的结果，取大者
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0), rob(nums, 1));
    }
    public static int rob(int[] nums, int start) {
        int pre = 0, cur = 0, res = 0;
        for (int i = start; i < nums.length - 1 + start; i++) {
            res = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = res;
        }
        return res;
    }
}
