package sort;

import java.util.Arrays;

/**
 * Created by 15501 on 2018/10/28.
 */
public class WiggleSort324 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
//        int[] nums = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums);
        for (int num : nums) System.out.print(num + "   ");
    }

    // 要求：nums[0] < nums[1] > nums[2] < nums[3]
    public static void wiggleSort(int[] nums) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);
        int j = (nums.length + 1) / 2, k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i & 1) == 0 ? temp[--j] : temp[--k];
        }
    }
}
