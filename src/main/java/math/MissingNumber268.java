package math;

/**
 * Created by 15501 on 2019/2/7.
 */
public class MissingNumber268 {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
        nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    // 使用数组的方法
    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length && i != nums[i]) {
                swap(nums, i, nums[i]);
                i--; // 这一步很重要
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return nums.length;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 利用二进制的方法
//    public static int missingNumber(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            res ^= (i + 1) ^ nums[i];
//        }
//        return res;
//    }

    // 利用数学的方法
//    public static int missingNumber(int[] nums) {
//        int sum = (1 + nums.length) * nums.length / 2, res = 0;
//        for (int num : nums) {
//            res += num;
//        }
//        return sum - res;
//    }
}
