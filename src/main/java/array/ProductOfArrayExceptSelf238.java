package array;

/**
 * Created by 15501 on 2019/2/5.
 */
public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        for (int num : productExceptSelf(nums)) System.out.print(num + ", ");
        System.out.println();
        nums = new int[]{24,12,8,6};
        for (int num : productExceptSelf(nums)) System.out.print(num + ", ");
        System.out.println();
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1], right = new int[n + 1], output = new int[n];
        left[0] = 1; right[n] = 1;
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] * nums[i];
            right[n - i - 1] = right[n - i] * nums[n - i - 1];
        }
        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i + 1];
        }
        return output;
    }

    // 时间复杂度 O(n)，空间复杂度O(1)，除去输出数组的空间复杂度
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] output = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (i == 0) output[i] = 1;
//            else output[i] = output[i - 1] * nums[i - 1];
//        }
//        int prod = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            if (i == n - 1) {
//                output[i] *= prod;
//            } else output[i] *= prod;
//            prod *= nums[i];
//        }
//        return output;
//    }
}
