package array;

/**
 * Created by 15501 on 2019/1/28.
 */
public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 2;


        rotate(nums, k);
        for (int num : nums) System.out.print(num + ", ");
        System.out.println();

        nums = new int[]{1,2,3,4,5,6,7}; k = 3;
        rotate(nums, k);
        for (int num : nums) System.out.print(num + ", ");
        System.out.println();
        System.out.println(Integer.toBinaryString(1 << 31));
    }

    public static void rotate(int[] nums, int k) {

        k %= nums.length;

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }

    }
}
