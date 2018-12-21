package array;

/**
 * Created by user on 2018/12/19.
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int n : nums) System.out.print(n + "   ");
        System.out.println();
        nums = new int[]{3,2,1};
        nextPermutation(nums);
        for (int n : nums) System.out.print(n + "   ");
        System.out.println();
        nums = new int[]{1,1,5};
        nextPermutation(nums);
        for (int n : nums) System.out.print(n + "   ");
        System.out.println();
    }
    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int n = nums.length, i = n - 2, j = n - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++; j--;
        }
    }
}
