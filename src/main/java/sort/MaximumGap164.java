package sort;

import java.util.Arrays;

/**
 * Created by 15501 on 2018/10/28.
 */
public class MaximumGap164 {
    public static void main(String[] args) {
//        int[] nums = {3,6,9,1};
//        int[] nums = {10};
//        int[] nums = {};
        int[] nums = {1, 10000000};
        System.out.println(maximumGap(nums));
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
//        radixSort(nums);
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
    private static int[] radixSort(int[] nums) {
        int n = nums.length, max = 0;
        for (int num : nums) max = Math.max(max, num);
        for (int exp = 1; exp <= max; exp *= 10)
            bucketSort(nums, n, exp);
        return nums;
    }
    private static int[] bucketSort(int[] nums, int n, int exp) {
        int[] temp = new int[n], bucket = new int[10];
        for (int num : nums) bucket[num / exp % 10]++;
        for (int i = 1; i < 10; i++) bucket[i] += bucket[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            temp[bucket[nums[i] / exp % 10] - 1] = nums[i];
            bucket[nums[i] / exp % 10]--;
        }
        System.arraycopy(temp, 0, nums, 0, n);
        return nums;
    }
}
