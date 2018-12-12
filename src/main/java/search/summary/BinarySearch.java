package search.summary;

import java.util.Arrays;

/**
 * Created by 15501 on 2018/11/2.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.binarySearch(nums, 4));
//        System.out.println(binarySearch(nums, 4));
//        System.out.println(binarySearch(nums, 4, 0, nums.length - 1));
//        System.out.println(insertSearch(nums, 4));
//        System.out.println(insertSearch(nums, 4, 0, nums.length - 1));
        System.out.println(fbSearch(nums, 4));

        int[] nums1 = {1, 2, 3, 4, 4, 5};
//        System.out.println(Arrays.binarySearch(nums1, 4));
//        System.out.println(binarySearch(nums1, 4));
//        System.out.println(binarySearch(nums1, 4, 0, nums1.length - 1));
//        System.out.println(insertSearch(nums1, 4));
//        System.out.println(insertSearch(nums1, 4, 0, nums1.length - 1));
        System.out.println(fbSearch(nums1, 4));

        int[] nums2 = {4};
//        System.out.println(Arrays.binarySearch(nums2, 4));
//        System.out.println(binarySearch(nums2, 4));
//        System.out.println(binarySearch(nums2, 4, 0, nums2.length - 1));
//        System.out.println(insertSearch(nums2, 4));
//        System.out.println(insertSearch(nums2, 4, 0, nums2.length - 1));
        System.out.println(fbSearch(nums2, 4));

        int[] nums3 = {4, 4, 4, 4};
//        System.out.println(Arrays.binarySearch(nums3, 4));
//        System.out.println(binarySearch(nums3, 4));
//        System.out.println(binarySearch(nums3, 4, 0, nums3.length - 1));
//        System.out.println(insertSearch(nums3, 4));
//        System.out.println(insertSearch(nums3, 4, 0, nums3.length - 1));
        System.out.println(fbSearch(nums3, 4));

        int[] nums4 = {};
//        System.out.println(Arrays.binarySearch(nums4, 4));
//        System.out.println(binarySearch(nums4, 4));
//        System.out.println(binarySearch(nums4, 4, 0, nums4.length - 1));
//        System.out.println(insertSearch(nums4, 4));
//        System.out.println(insertSearch(nums4, 4, 0, nums4.length - 1));
        System.out.println(fbSearch(nums4, 4));
    }

    // 算法要考虑nums为空
    // 下面算法能够确保找到的value一定是数组第一次出现的位置
    // 而Arrays.binarySearch不能确保这一点
    public static int binarySearch(int[] nums, int value) {
        if (nums.length < 1) return -1;
        int start = 0, end = nums.length - 1, mid = (start + end) / 2;
        while (start <= end) {
            if (nums[mid] >= value) end = mid - 1;
            else start = mid + 1;
            mid = (start + end) / 2;
        }
        if (nums[start] == value) return start;
        else return -1;
    }
    public static int binarySearch(int[] nums, int value, int start, int end) {
        if (nums.length < 1) return -1;
        if (start > end) {
            if (nums[start] == value) return start;
            else return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] >= value) return binarySearch(nums, value, start, mid - 1);
        else return binarySearch(nums, value, mid + 1, end);
    }

    // 插入查找，通过改变mid的定位来改进二分查找
    // mid = start + (value - nums[start]) / (nums[end] - nums[start]) * (end - start)
    // 此算法一定得考虑nums[end] == nums[start]的情况
    public static int insertSearch(int[] nums, int value) {
        if (nums.length < 1) return -1;
        int start = 0, end = nums.length - 1;
        if (start > end || nums[start] == nums[end]) {
            if (nums[start] == value) return start;
            else return -1;
        }
        int mid = start + (value - nums[start]) / (nums[end] - nums[start]) * (end - start);
        while (start <= end) {
            if (nums[mid] >= value) end = mid - 1;
            else start = mid + 1;
            mid = start + (value - nums[start]) / (nums[end] - nums[start]) * (end - start);
        }
        if (nums[start] == value) return start;
        else return -1;
    }
    public static int insertSearch(int[] nums, int value, int start, int end) {
        if (nums.length < 1) return -1;
        if (start > end || nums[start] == nums[end]) {
            if (nums[start] == value) return start;
            else return -1;
        }
        int mid = start + (value - nums[start]) / (nums[end] - nums[start]) * (end - start);
        if (nums[mid] >= value) return insertSearch(nums, value, start, mid - 1);
        else return insertSearch(nums, value,mid + 1, end);
    }

    public static int fbSearch(int[] nums, int value) {
        int n = nums.length;
        if (n < 1) return -1;
        int[] fb = makeFbArray(20);
        int k = 0;
        while (n > fb[k] - 1) k++;
        int[] temp = new int[fb[k] - 1];
        for (int i = 0; i < fb[k] - 1; i++) {
            if (i >= n) temp[i] = nums[n - 1];
            else temp[i] = nums[i];
        }
        int start = 0, end = n - 1, mid;
        while (start <= end) {
            mid = start + fb[k - 1] - 1;
            if (nums[mid] > value) {
                end = mid - 1;
                k -= 1;
            } else if (nums[mid] < value) {
                start = mid + 1;
                k -= 2;
            } else {
                if (mid <= end) return mid;
                else return end;
            }
        }
        return -1;
    }
    public static int[] makeFbArray(int length) {
        int[] fb = new int[length];
        if (length < 1) return fb;
        if (length < 2) {
            fb[0] = 1;
            return fb;
        }
        if (length >= 2) {
            fb[0] = 1; fb[1] = 1;
        }
        for (int i = 2; i < length; i++) {
            fb[i] = fb[i - 1] + fb[i - 2];
        }
        return fb;
    }
}
