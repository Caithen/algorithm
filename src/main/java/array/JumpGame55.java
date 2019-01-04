package array;

/**
 * Created by user on 2019/1/3.
 */
public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
        nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
        nums = new int[]{};
        System.out.println(canJump(nums));
        nums = new int[]{0};
        System.out.println(canJump(nums));
    }

    // 下面的方法更快
    public static boolean canJump(int[] nums) {
        int pre = 0, cur = 0, i = 0;
        while (cur < nums.length - 1) {
            pre = cur;
            for (; i <= pre; i++) cur = Math.max(cur, i + nums[i]);
            if (pre == cur) return false;
        }
        return true;
    }

//    public static boolean canJump(int[] nums) {
//        int right = nums.length - 1;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] >= right - i) right = i;
//        }
//        return right == 0;
//    }
}
