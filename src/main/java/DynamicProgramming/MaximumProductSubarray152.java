package DynamicProgramming;

/**
 * Created by user on 2018/12/20.
 */
public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
        nums = new int[]{-2,0,-1};
        System.out.println(maxProduct(nums));
        nums = new int[]{-2};
        System.out.println(maxProduct(nums));
        nums = new int[]{-2,3,-4};
        System.out.println(maxProduct(nums));
    }

    // 使用max和min分别记录包含当前值的最大值和最小值
    public static int maxProduct(int[] nums) {
        if (nums.length < 1) return 0;
        int res = nums[0], min = res, max = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                max = max + min;
                min = max - min;
                max = max - min;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    // 下面是暴力解法
//    public static int maxProduct(int[] nums) {
//        if (nums.length < 1) return 0;
//        int res = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            int product = 1;
//            for (int j = i; j < nums.length; j++) {
//                product = product * nums[j];
//                res = Math.max(res, product);
//            }
//        }
//        return res;
//    }
}
