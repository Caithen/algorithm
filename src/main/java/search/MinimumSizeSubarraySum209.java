package search;

/**
 * Created by 15501 on 2018/12/10.
 */
public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
        System.out.println(minSubArrayLen(1, nums));
        System.out.println(minSubArrayLen(100, nums));
    }

    // 下面使O(n)的方法，比较常规
//    public static int minSubArrayLen(int s, int[] nums) {
//        int window = 0, sum = 0, min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            window++;
//            while (sum >= s) {
//                min = Math.min(window, min);
//                sum -= nums[i - window + 1];
//                window--;
//            }
//        }
//        if (min == Integer.MAX_VALUE) return 0;
//        else return min;
//    }
    // 把window换成双指针的解法
//    public static int minSubArrayLen(int s, int[] nums) {
//        int left = 0, sum = 0, min = nums.length + 1;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            while (sum >= s) {
//                min = Math.min(min, i - left + 1);
//                sum -= nums[left++];
//            }
//        }
//        return min == nums.length + 1 ? 0 : min;
//    }

    // 使用O(n)的方法
    public static int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        int[] sums = new int[min];
        sums[0] = 0;
        for (int i = 1; i < min; i++) sums[i] = sums[i - 1] + nums[i - 1];
        for (int i = 0; i < sums.length; i++) {
            int left = i + 1, right = sums.length - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (sums[mid] < sums[i] + s) left = mid + 1;
                else right = mid - 1;
            }
            if (left == sums.length) break;
            min = Math.min(min, left - i);
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
