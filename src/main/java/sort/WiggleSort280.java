package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 15501 on 2018/11/1.
 */
public class WiggleSort280 {
    public static void main(String[] args) {
//        int[] nums = {3, 5, 2, 1, 6, 4};
        int[] nums = {1, 6, 2, 5, 3, 4};
        printArray(wiggleSort(nums));
    }

    // 第一种解法：
    // 数组排序，调换位置（第二个数和第三个数交换，
    // 第四个数和第五个数交换，以此类推）
//    public static int[] wiggleSort(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 2; i < nums.length; i += 2) {
//            int temp = nums[i];
//            nums[i] = nums[i - 1];
//            nums[i - 1] = temp;
//        }
//        return nums;
//    }

    // 第二种解法：
    // 虽然要求nums[0] <= nums[1] >= nums[2] <= nums[3]....
    // 即局部排序，但并没有要求数组整体排序，并且相邻元素可以相等，
    // 所以只需要遍历一遍数组，不符合条件，则交换。
    public static int[] wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((i & 1) == 1 && nums[i] < nums[i - 1]) || ((i & 1) == 0) && nums[i] > nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
        return nums;
    }
    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }
}
