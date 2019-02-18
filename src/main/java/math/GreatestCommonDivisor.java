package math;

/**
 * Created by 15501 on 2019/2/10.
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(4, 6));
        System.out.println(gcd(2, 9));
        int[] nums = {2, 4, 6, 8, 10, 9};
        System.out.println(multiGDD(nums));
    }
    // 求两个数的公约数
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 求多个数的公约数
    public static int multiGDD(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = gcd(res, nums[i]);
        }
        return res;
    }
}
